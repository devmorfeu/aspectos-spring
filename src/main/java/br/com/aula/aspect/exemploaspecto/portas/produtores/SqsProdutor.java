package br.com.aula.aspect.exemploaspecto.portas.produtores;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SqsProdutor {

    private final SqsTemplate sqsTemplate;

    public void enviaResultadoSqs(int resultado) {

        sqsTemplate.send(sqsSendOptions -> sqsSendOptions.queue("sqs-fila-produtor-teste").payload(resultado));
    }
}
