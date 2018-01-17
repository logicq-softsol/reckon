package com.logicq.reckon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class ReckonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReckonApplication.class, args);
	}
}
