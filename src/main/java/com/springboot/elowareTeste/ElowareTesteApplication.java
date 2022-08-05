package com.springboot.elowareTeste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(".com.springboot.elowareTeste.repository")
public class ElowareTesteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElowareTesteApplication.class, args);
	}

}
