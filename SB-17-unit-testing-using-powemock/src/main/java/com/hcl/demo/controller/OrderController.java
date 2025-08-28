package com.hcl.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.demo.dto.OrderRequest;
import com.hcl.demo.dto.OrderResponse;
import com.hcl.demo.service.OrderService;

@RestController
public class OrderController {

	
	@Autowired
	private OrderService service;
	
	@PostMapping("/placeOrder")
	public OrderResponse placeOrder(@RequestBody OrderRequest request){
		return service.checkOutOrder(request);
}
}