package com.capstone.restArea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class RestAreaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestAreaApplication.class, args);
	}

}
