package io.spring.arquiteturaspring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExemploValue {

    // Estamos lendo o application.yml para injetar aqui via propriedade
    @Value("${app.config.variavel}")  // Injeta o valor da propriedade do application.yml atravez de '${}'
    private String variavel;

    public void imprimirVariavel() {
        System.out.println(variavel);
    }

}
