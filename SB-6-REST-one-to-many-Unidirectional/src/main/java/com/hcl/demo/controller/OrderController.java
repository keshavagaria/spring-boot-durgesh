package com.hcl.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.demo.dto.OrderRequest;
import com.hcl.demo.dto.OrderResponse;
import com.hcl.demo.entity.Customer;
import com.hcl.demo.repository.CustomerRepository;
import com.hcl.demo.service.CustomerService;

@RestController
public class OrderController {
	
	@Autowired
	private CustomerService customerService;
	
	//@Autowired
	//private ProductRepository productRepository;

	@PostMapping("/placeOrder")
	public Customer placeOrder(@RequestBody OrderRequest orderRequest) {
		
		 Customer customer=customerService.save(orderRequest.getCustomer());
		return customer;
	}
	
	@GetMapping("/getAllOrders")
	public List<Customer> findAllOrders(){
		
	//	return customerService.findAllOrders();
		return customerService.findNPlusOneSolved();
	}
	
	@GetMapping("/getCustomer/{id}")
	public Customer findCustomerById(@PathVariable Integer id){
			Customer customer = customerService.findCustomerById(id);
		return customer;
		
	}
	@GetMapping("/getJoinInfo")
	public List<OrderResponse> getJoinInformation(){
		
		return customerService.getJoinInformation();
		
	}
}
