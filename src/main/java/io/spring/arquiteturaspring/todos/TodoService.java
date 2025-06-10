package io.spring.arquiteturaspring.todos;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository repository;

    // Como eh uma classe gerenciada pelo Spring (por ser um service) nao precisamos do Autowired, o proprio Spring vai procurar dentro do container
    // Uma instancia de TodoRepository para injetar neste construtor automaticamente
    public TodoService(TodoRepository todoRepository){
        this.repository = todoRepository;
    }

    public TodoEntity salvar(TodoEntity novoEntity) {
        return repository.save(novoEntity);
    }

    public void atualizarStatus(TodoEntity todo) {
        repository.save(todo);  // Se a entidade ja possuir Id, vai atualiza-lo
    }

    public TodoEntity buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
