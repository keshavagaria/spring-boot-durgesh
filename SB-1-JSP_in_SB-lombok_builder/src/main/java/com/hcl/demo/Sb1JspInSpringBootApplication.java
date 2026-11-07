package com.hcl.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hcl.demo.entity.Employee;

@SpringBootApplication
public class Sb1JspInSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sb1JspInSpringBootApplication.class, args);
		
		Employee employee = new Employee()
										.builder()
										.id(201)
										.name("Aman")
										.salary(5000)
										.build();
				
		
//		employee.setId(101);
//		employee.setName("Vishal");
//		employee.setSalary(1000);
		
		System.out.println(employee);
	}

}
