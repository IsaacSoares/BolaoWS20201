package br.edu.uniateneu.bolao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EntityScan("br.edu.uniateneu.bolao.model*")
@EnableJpaRepositories("br.edu.uniateneu.bolao.repository")
@SpringBootApplication
public class BolaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BolaoApplication.class, args);
	}

}
