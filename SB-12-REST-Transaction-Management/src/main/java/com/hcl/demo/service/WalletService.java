package com.hcl.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WalletService {


	  	@Autowired
	    private UserService userService;

	  	@Transactional(propagation = Propagation.REQUIRED)
	    public void transfer(Long senderId, Long receiverId, Double amount) {
	        userService.debit(senderId, amount);
	        userService.credit(receiverId, amount);
	    }

}
