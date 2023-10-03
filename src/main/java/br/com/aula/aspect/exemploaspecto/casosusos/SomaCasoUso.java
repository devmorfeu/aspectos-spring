package br.com.aula.aspect.exemploaspecto.casosusos;

import br.com.aula.aspect.exemploaspecto.portas.consumidores.modelos.DadosEntrada;
import org.springframework.stereotype.Component;

@Component
public class SomaCasoUso {

    public int somaNumeros(final DadosEntrada dadosEntrada) {
        return dadosEntrada.getPrimeiroNumero() + dadosEntrada.getSegundoNumero();
    }
}
