package com.hcl.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	private int id;
	
	@NotBlank(message = "Name cannot be blank")
	private String name;
	
	@Min(value = 20, message = "Minimum age should be 20")
	@Max(value = 100, message = "Maximum age should be 100")
	private int age;
	
	@Email
	@NotBlank(message = "Email should not be blank")
	private String emailAddress;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", emailAddress=" + emailAddress + "]";
	}


}
