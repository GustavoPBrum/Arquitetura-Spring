package io.spring.arquiteturaspring.montadora.api;

import io.spring.arquiteturaspring.montadora.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carros")  // Se nao definir, ficara na URL raiz
public class TesteFabricaController {

    @Autowired // Diz para o Spring ir no container e dar uma instancia de motor, que ja tem la registrado e quero injeta-lo aqui
    @Turbo  // Alem de deixar o cogido mais clean, evita de errarmos o nome utilizando Qualifiers
    // o Bean abaixo possui o nome errado do Bean no container, mas o @turbo tira o erro pois esta com o nome correto na Annotation
    //@Qualifier("motoTurbo") // Passamos o nome do Bean que queremos que seja injetado (apenas quando ha mais de um Bean do mesmo tipo registrado no container)
    private Motor motor;

    @PostMapping
    public CarroStatus ligarCarro(@RequestBody Chave chave) {  // RequestBody pois vai receber via JSON a chave para ligar o carro
        var carro = new HondaHRV(motor);
        return carro.darIgnicao(chave);
    }
}
