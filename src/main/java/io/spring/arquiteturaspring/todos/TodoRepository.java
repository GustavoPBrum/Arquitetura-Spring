package io.spring.arquiteturaspring.todos;

import org.springframework.data.jpa.repository.JpaRepository;

// Uma das poucas classes SCANEADAS SEM PRECISAR DE ANNOTATION
public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {
    boolean existsByDescricao(String descricao);
}
