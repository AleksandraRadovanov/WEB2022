package com.ftn.wolt2022;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication
public class Wolt2022Application {

	public static void main(String[] args) {
		SpringApplication.run(Wolt2022Application.class, args);
	}
}
