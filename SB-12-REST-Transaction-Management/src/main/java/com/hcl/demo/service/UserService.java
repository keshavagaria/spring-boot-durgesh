package com.hcl.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.demo.entity.User;
import com.hcl.demo.repository.UserRepository;

@Service
public class UserService {
    
	@Autowired
    private UserRepository userRepository;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
    public void debit(Long userId, Double amount) {
        User user = userRepository.findById(userId).orElseThrow();
        user.setBalance(user.getBalance()-amount);
        userRepository.save(user);
    }

	@Transactional(propagation = Propagation.REQUIRES_NEW)
    public void credit(Long userId, Double amount) {
        User user = userRepository.findById(userId).orElseThrow();
        user.setBalance(user.getBalance()+amount);
        int i = 10/0;
        
        userRepository.save(user);
    }
}    