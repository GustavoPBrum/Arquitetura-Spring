package io.spring.arquiteturaspring.montadora.api;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
// CAMPO e METODO
@Target({ElementType.FIELD, ElementType.METHOD})  // Tipo de propriedade, classe ou metodo que essa annotation vai aparecer
@Qualifier("motorAspirado")
public @interface Aspirado {
}
