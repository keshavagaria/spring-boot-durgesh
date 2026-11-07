package com.hcl.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hcl.demo.dao.EmployeeRepository;
import com.hcl.demo.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	public List<Employee> findAllEmployees(Pageable pageable, String search) {
		
		 if(search==null) {
	            return repository.findAll(pageable).getContent();
	        } else {
	            return repository.findByName(search, pageable).getContent();
	        }
	}

	

}
