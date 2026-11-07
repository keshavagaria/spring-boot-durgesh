package com.hcl.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.demo.service.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalletController {

	 @Autowired 
	 private WalletService service;

	    @PostMapping("/transfer")
	    public String transfer(@RequestParam Long senderId,
	                           @RequestParam Long receiverId,
	                           @RequestParam Double amount) {
	        try {
	            service.transfer(senderId, receiverId, amount);
	        } catch (Exception e) {
	            return "Transfer failed: " + e.getMessage();
	        }
	        return "Transfer completed";
	    }
}
