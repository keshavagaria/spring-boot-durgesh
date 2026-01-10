package com.hcl.demo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin("*")
public class NotificationController {
	
	// server app

	@GetMapping("/admin")
	public  String admin(String message) {
		
		System.out.println(message);
		return "admin";
	}
	
	@GetMapping("/client1")
	public  String client1(String message) {
		
		System.out.println(message);
		return "client1";
	}
	
	@GetMapping("/client2")
	public  String client2(String message) {
		
		System.out.println(message);
		return "client2";
	}
	
	@MessageMapping("/sendMessage")
	@SendTo("/topic/notifications")
	public  String sendMesage(String message) {
		
		System.out.println(message);
		return message;
	}
}
