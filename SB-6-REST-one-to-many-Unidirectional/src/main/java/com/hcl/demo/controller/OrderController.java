package com.hcl.demo.controller;

import java.util.List;
import java.util.Optional;

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
import com.hcl.demo.repository.ProductRepository;

@RestController
public class OrderController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@PostMapping("/placeOrder")
	public Customer placeOrder(@RequestBody OrderRequest orderRequest) {
		
		 Customer customer=customerRepository.save(orderRequest.getCustomer());
		return customer;
	}
	
	@GetMapping("/getAllOrders")
	public List<Customer> findAllOrders(){
		
		return customerRepository.findAll();
		//return customerRepository.findWithoutNPlusOne();
	}
	
	@GetMapping("/get/{id}")
	public Customer findById(@PathVariable Integer id){
			Customer customer = customerRepository.findById(id).get();
		return customer;
		
	}
	@GetMapping("/getJoinInfo")
	public List<OrderResponse> getJoinInformation(){
		
		return customerRepository.getJoinInformation();
		
	}
}
