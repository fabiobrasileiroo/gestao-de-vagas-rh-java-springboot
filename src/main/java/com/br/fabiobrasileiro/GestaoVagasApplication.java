package com.br.fabiobrasileiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// @ComponentScan(basePackages = "com.br.fabiobrasileiro")
// @EntityScan(basePackages = "com.br.fabiobrasileiro.gestao_vagas.modules")
// @EnableJpaRepositories(basePackages = "com.br.fabiobrasileiro.gestao_vagas.modules")
public class GestaoVagasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoVagasApplication.class, args);
	}

}
