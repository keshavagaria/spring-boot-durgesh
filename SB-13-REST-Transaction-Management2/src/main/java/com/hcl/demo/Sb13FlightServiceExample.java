package com.hcl.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Sb13FlightServiceExample {

	public static void main(String[] args) {
		SpringApplication.run(Sb13FlightServiceExample.class, args);
	}

}
