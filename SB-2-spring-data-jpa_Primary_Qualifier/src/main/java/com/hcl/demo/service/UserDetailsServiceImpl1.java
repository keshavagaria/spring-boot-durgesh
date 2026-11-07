package com.hcl.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.demo.dao.UserRepository;
import com.hcl.demo.entity.UserDetails;

@Service
public class UserDetailsServiceImpl1 implements UserDetailsService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public Optional<UserDetails> getUserById(int id) {
		
		return repository.findById(id);
	}

	@Override
	public List<UserDetails> getAllUsers() {
		// TODO Auto-generated method stub
		return (List<UserDetails>) repository.findAll();
	}

}
