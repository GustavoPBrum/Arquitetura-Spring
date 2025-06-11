package io.spring.arquiteturaspring;

import io.spring.arquiteturaspring.todos.*;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;

public class ExemploInjecaoDependencia {
    public static void main(String[] args) throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("url");
        dataSource.setUsername("User");
        dataSource.setPassword("Password");

        Connection connection = dataSource.getConnection();

        EntityManager entityManager = null;

        TodoRepository repository = null ; //new SimpleJpaRepository<TodoEntity, Integer>();
        TodoValidator todoValidator = new TodoValidator(repository);
        MailSender mailSender = new MailSender();

        // Todo o comando acima foi feito para somente implementar o service.
        TodoService service = new TodoService(repository, todoValidator, mailSender);

        BeanGerenciado beanGerenciado = new BeanGerenciado(null);
        beanGerenciado.setValidator(todoValidator);
        //if(condicao == true) {
        //    beanGerenciado.setValidator(null);
        //}
    }
}
