package com.hcl.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.hcl.demo.entity.UserDetails;

@Configuration
public class UserDetailsConfig {
	
	@Bean
	public UserDetails getUserDetails1() {
		
		return new UserDetails(1, "Keshav", "Delhi", "Sexy");
	}

	@Bean
	@Primary
	public UserDetails getUserDetails2() {
		
		return new UserDetails(2, "Vishu", "Bangalore", "Sexy");
	}
}
