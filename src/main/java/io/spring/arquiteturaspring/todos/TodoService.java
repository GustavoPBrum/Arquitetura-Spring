package io.spring.arquiteturaspring.todos;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository repository;
    private TodoValidator validator;
    private MailSender mailSender;

    // Service injeta o Repository [...] para fazer operacoes com BD
    // Como eh uma classe gerenciada pelo Spring (por ser um service) nao precisamos do Autowired, o proprio Spring vai procurar dentro do container
    // Uma instancia de TodoRepository para injetar neste construtor automaticamente
    public TodoService(TodoRepository repository, TodoValidator validator, MailSender mailSender) {
        this.repository = repository;
        this.validator = validator;
        this.mailSender = mailSender;
    }

    public TodoEntity salvar(TodoEntity novoEntity) {
        validator.validar(novoEntity);
        return repository.save(novoEntity);
    }

    public void atualizarStatus(TodoEntity todo) {
        repository.save(todo);  // Se a entidade ja possuir Id, vai atualiza-lo
        String status = todo.getConcluido() == Boolean.TRUE ? "Concluido" : "Nao concluido";
        mailSender.enviar("Todo " + todo.getDescricao() + " foi atualizado para " + status);
    }

    public TodoEntity buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
