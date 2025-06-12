package io.spring.arquiteturaspring;

import io.spring.arquiteturaspring.todos.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigAcessoEmail {

    // Podemos utilizar essas propriedades com *@Value* ou criando classes para agrupar o tipo de propriedade em uma classe...
    // Utilizando o *@ConfigurationProperties*
    @Autowired
    private AppProperties properties;

    //@Bean
    public MailSender mailSender(){
        return null;
    }

}
