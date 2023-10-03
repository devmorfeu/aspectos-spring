package br.com.aula.aspect.exemploaspecto.aspectos;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Import(SqsConsumoAspectoImpl.class)
public @interface SqsConsumoAspecto {

    String fila() default "";
}
