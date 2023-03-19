package com.br.calcme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class CalcmeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalcmeApplication.class, args);
	}

}
