
package com.hcl.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class Sb2026IqApplication {

	@Value("${spring.profiles.active}")
	private String profile;
	@Value("${spring.application.name}")
	private String app;
	
	public static void main(String[] args) {
		
		// 1. @Profile
		// 2. Circular dependency
		// 3. Ways to read properties from config file and how to read in a Collection
		SpringApplication.run(Sb2026IqApplication.class, args);
	}

	@PostConstruct
	public void init() {
		
		 System.out.println(profile+" "+app);
	}
}
