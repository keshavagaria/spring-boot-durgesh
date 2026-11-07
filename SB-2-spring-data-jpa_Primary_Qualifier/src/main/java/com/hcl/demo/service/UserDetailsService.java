package com.hcl.demo.service;

import java.util.List;
import java.util.Optional;

import com.hcl.demo.entity.UserDetails;


public interface UserDetailsService {

	Optional<UserDetails> getUserById(int id);
	
	List<UserDetails> getAllUsers();
}
