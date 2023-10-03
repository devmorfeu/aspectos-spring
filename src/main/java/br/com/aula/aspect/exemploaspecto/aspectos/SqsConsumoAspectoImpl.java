package br.com.aula.aspect.exemploaspecto.aspectos;

import br.com.aula.aspect.exemploaspecto.portas.consumidores.modelos.DadosEntrada;
import br.com.aula.aspect.exemploaspecto.portas.produtores.SqsProdutorDLQ;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class SqsConsumoAspectoImpl {

    private final SqsProdutorDLQ sqsProdutorDLQ;

    @Around(value = "@annotation(sqsConsumoAspecto)")
    public void gerenciandoAspectosSqsConsumo(ProceedingJoinPoint proceedingJoinPoint, SqsConsumoAspecto sqsConsumoAspecto) {

        final var evento = proceedingJoinPoint.getArgs()[0];

        try {

            if (evento instanceof DadosEntrada) {

                log.info("Mensagem recebida do SQS {} {}", evento, sqsConsumoAspecto.fila());

                proceedingJoinPoint.proceed();
            }

        } catch (Throwable erro) {

            log.error("Erro ao processar mensagem {}", erro.getMessage());

            sqsProdutorDLQ.enviaErroDql((Exception) erro, (DadosEntrada) evento, sqsConsumoAspecto.fila());

            throw new RuntimeException(erro);
        }
    }
}
