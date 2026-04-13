package com.hcl.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Sb12RestTransactionManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sb12RestTransactionManagementApplication.class, args);
	}

}
