package io.spring.arquiteturaspring;

import io.spring.arquiteturaspring.todos.TodoEntity;
import io.spring.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Lazy serve para ter um controle na nossa aplicacao do que sera instanciado
//@Lazy(false)  // padrao do @Lazy eh true, vai instanciar os beans somente na hora que for utiliza-los, mas pode dar um erro em RunTime
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)  // Instancia unica de um obj que vai atender a toda a aplicacao (padrao Spring)
//@Scope("singleton") // ou
//@Scope(WebApplicationContext.SCOPE_REQUEST)
//@Scope(WebApplicationContext.SCOPE_REQUEST)
//@Scope(WebApplicationContext.SCOPE_REQUEST)
//@Scope("request")  //-> vai existir apenas durante a requisicao, instanciado na hora da requisicao e depois nao existe mais
//@Scope("session")  //-> objeto que dura durante secao do usuario
//@Scope("application")  //-> parecido com o 'session', mas se estende a todos os usuarios (e so serve pra aplicacoes web)

public class BeanGerenciado {

    @Autowired
    private TodoValidator validator; // Injecao via propriedade

    //@Autowired
    //private AppProperties properties;  // Comum utilizar isto para fazer dentro de classes de configurations

    public BeanGerenciado(TodoValidator validator) {  // Injecao via construtor e recomendado pelo Spring
        this.validator = validator;
        //String variavel = properties.getVariavel();
    }

    public void utilizar() {
        var todo = new TodoEntity();
        validator.validar(todo);
    }

    // Injecao via Setter
    @Autowired
    public void setValidator(TodoValidator validator) {
        this.validator = validator;
    }
}
