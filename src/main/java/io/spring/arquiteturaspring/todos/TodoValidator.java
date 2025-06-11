package io.spring.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    private TodoRepository repository;

    public TodoValidator(TodoRepository repository) {
        this.repository = repository;
    }

    public void validar(TodoEntity todo){
        if(existeTodoDescricao(todo.getDescricao())) {
            throw new IllegalArgumentException("Ja existe um TODO com essa descricao!");
        }
    }

    private boolean existeTodoDescricao(String descricao) {
        return repository.existsByDescricao(descricao);
    }
}
