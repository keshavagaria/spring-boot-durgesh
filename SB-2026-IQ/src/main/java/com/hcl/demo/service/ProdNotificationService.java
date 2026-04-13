package com.hcl.demo.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class ProdNotificationService implements NotificationService{

	@Override
	public void send(String message) {
		// TODO Auto-generated method stub // Real email/SMS integration
        System.out.println("PROD Notification: " + message);
		
	}

}
