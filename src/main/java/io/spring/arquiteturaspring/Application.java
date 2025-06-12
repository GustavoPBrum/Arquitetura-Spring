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

		//builder.lazyInitialization(true);  // Com essa config, por padrao, todos os beans sao Lazy

		// Sempre passar esses args, pois podem ser passados dentro de um container docker ou quisermos passar alguns parametros Spring
		builder.run(args);

		// Para acessar o contexto da application, ela precisa ser startada primeiro
		ConfigurableApplicationContext applicationContext = builder.context();

		// Busca um bean que esta dentro de um container, *SO PODE SER ACESSADO APOS DAR RUN*
		//var produtoRepository = applicationContext.getBean("produtoRepository");

		// Podemos acessar todas as propriedades do projeto
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String applicationName = environment.getProperty("spring.application.name");
		System.out.println("Nome da aplicacao: " + applicationName);

		// Quando formos referenciar o nome de algum Bean, eh o nome da classe comecando com letra Minuscula ou o com o nome e .class
		ExemploValue value = applicationContext.getBean(ExemploValue.class);  // "exemploValue"
		value.imprimirVariavel();
	}

}
