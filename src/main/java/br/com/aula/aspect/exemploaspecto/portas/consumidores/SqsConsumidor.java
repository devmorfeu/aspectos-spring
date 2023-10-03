package br.com.aula.aspect.exemploaspecto.portas.consumidores;

import br.com.aula.aspect.exemploaspecto.aspectos.SqsConsumoAspecto;
import br.com.aula.aspect.exemploaspecto.casosusos.SomaCasoUso;
import br.com.aula.aspect.exemploaspecto.portas.consumidores.modelos.DadosEntrada;
import br.com.aula.aspect.exemploaspecto.portas.produtores.SqsProdutor;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SqsConsumidor {

    private final SqsProdutor sqsProdutor;

    private final SomaCasoUso somaCasoUso;

    @SqsConsumoAspecto(fila = "sqs-teste-dlq")
    @SqsListener(value = "sqs-teste-consumo-fila")
    public void receberMensagens(final DadosEntrada dadosEntrada) {

        final var resultado = somaCasoUso.somaNumeros(dadosEntrada);

        sqsProdutor.enviaResultadoSqs(resultado);
    }
}
