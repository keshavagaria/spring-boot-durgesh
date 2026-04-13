package com.hcl.demo.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DevNotificationService implements NotificationService{

	@Override
	public void send(String message) {
		 System.out.println("DEV Notification: " + message);

		
	}

}
