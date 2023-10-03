package br.com.aula.aspect.exemploaspecto;

import br.com.aula.aspect.exemploaspecto.portas.consumidores.SqsConsumidor;
import br.com.aula.aspect.exemploaspecto.portas.consumidores.modelos.DadosEntrada;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExemploAspectApplication {

	@Autowired
	private SqsConsumidor sqsConsumidor;

	public static void main(String[] args) {
		SpringApplication.run(ExemploAspectApplication.class, args);
	}

	@PostConstruct
	public void test(){
		sqsConsumidor.receberMensagens(new DadosEntrada(10,10));
	}

}
