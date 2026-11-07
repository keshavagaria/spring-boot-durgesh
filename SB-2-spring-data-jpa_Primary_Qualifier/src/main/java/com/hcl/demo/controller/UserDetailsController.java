package com.hcl.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.demo.entity.UserDetails;
import com.hcl.demo.service.UserDetailsService;

@RestController
public class UserDetailsController {

	@Autowired
	@Qualifier("userDetailsServiceImpl1")
	private UserDetailsService userDetailsService;
	
	@Autowired
//	@Qualifier("getUserDetails1")
	private UserDetails userDetails;
	
	@GetMapping("/getDetailsById/{id}")
	public Optional<UserDetails> getDetailsById(@PathVariable int id) {
		
		return userDetailsService.getUserById(id);
	}
	
	@GetMapping("/getDetails")
	public List<UserDetails> getDetails() {
		
		return userDetailsService.getAllUsers();
	}
}
