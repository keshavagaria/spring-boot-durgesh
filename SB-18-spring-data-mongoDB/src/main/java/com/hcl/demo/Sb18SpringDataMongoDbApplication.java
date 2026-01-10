package com.hcl.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Sb18SpringDataMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sb18SpringDataMongoDbApplication.class, args);
	}

	@Bean
	public PlatformTransactionManager manager(MongoDatabaseFactory databaseFactory) {
		
		return new MongoTransactionManager(databaseFactory);
	}
	// PlatformTransanction Manager
	// MongoTransactionManager
}
