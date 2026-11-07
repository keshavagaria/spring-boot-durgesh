package com.hcl.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.demo.dto.OrderResponse;
import com.hcl.demo.entity.Customer;
import com.hcl.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	public List<Customer> findAllOrders() {
		
		return customerRepository.findAll();
		
	}

	public List<Customer> findNPlusOneSolved() {
		
		return customerRepository.findNPlusOneSolved();
	}

	public Customer findCustomerById(Integer id) {
		
	//	return customerRepository.findById(id).get();
		return customerRepository.findCustomerById(id).get();
	}

	public Customer save(Customer customer) {
		
		return customerRepository.save(customer);
	}

	public List<OrderResponse> getJoinInformation() {
		
		return customerRepository.getJoinInformation();
	}


	
	

}
