package io.spring.arquiteturaspring;

import io.spring.arquiteturaspring.todos.TodoEntity;
import io.spring.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;

@Component
public class BeanGerenciado {

    @Autowired
    private TodoValidator validator; // Injecao via propriedade

    public BeanGerenciado(TodoValidator validator) {  // Injecao via construtor e recomendado pelo Spring
        this.validator = validator;
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
