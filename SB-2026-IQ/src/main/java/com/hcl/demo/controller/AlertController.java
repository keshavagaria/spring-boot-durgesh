package com.hcl.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.demo.service.NotificationService;

@RestController
public class AlertController {
	
	 private final NotificationService notificationService;

	    public AlertController(NotificationService notificationService) {
	        this.notificationService = notificationService;
	    }

	    @GetMapping("/alert")
	    public String alert() {
	        notificationService.send("System alert!");
	        return "Alert sent";
	    }
}
