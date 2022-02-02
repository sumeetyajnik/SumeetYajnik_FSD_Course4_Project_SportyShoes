package com.sportyshoes.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SportyShoesRestfulApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportyShoesRestfulApiApplication.class, args);
	}

}
