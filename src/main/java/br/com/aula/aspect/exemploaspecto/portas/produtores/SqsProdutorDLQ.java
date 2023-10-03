package br.com.aula.aspect.exemploaspecto.portas.produtores;

import br.com.aula.aspect.exemploaspecto.portas.consumidores.modelos.DadosEntrada;
import org.springframework.stereotype.Service;

@Service
public class SqsProdutorDLQ {

    public void enviaErroDql(Exception erro, DadosEntrada dadosEntrada, String fila) {

    }
}
