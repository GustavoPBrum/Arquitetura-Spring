package io.spring.arquiteturaspring;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);

		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);

		builder.bannerMode(Banner.Mode.OFF);

		// Pode ter diferentes profiles para cada exemplo, producao, teste, debug
		builder.profiles("producao");

		// Sempre passar esses args, pois podem ser passados dentro de um container docker ou quisermos passar alguns parametros Spring
		builder.run(args);

		// Para acessar o contexto da application, ela precisa ser startada primeiro
		ConfigurableApplicationContext applicationContext = builder.context();

		// Busca um bean que esta dentro de um container, *SO PODE SER ACESSADO APOS DAR RUN*
		//var produtoRepository = applicationContext.getBean("produtoRepository");

		// Podemos acessar todas as propriedades do projeto
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String applicationName = environment.getProperty("string.application.name");
		System.out.println("Nome da aplicacao: " + applicationName);
	}

}
