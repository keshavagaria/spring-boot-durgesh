package com.hcl.demo.controller;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "customActuator")
public class CustomActuator {

	@ReadOperation
	public String currentDBDetails() {
		
		return "Give current DB status of thr app";
	}
}
