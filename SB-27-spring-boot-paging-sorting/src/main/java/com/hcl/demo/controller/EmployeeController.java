package com.hcl.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.demo.entity.Employee;
import com.hcl.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(@RequestParam(required = false, defaultValue = "1") int pageNo,
            							  @RequestParam(required = false, defaultValue = "5") int pageSize,
            							  @RequestParam(required = false, defaultValue = "id") String sortBy,
                                          @RequestParam(required = false, defaultValue = "ASC") String sortDir,
                                          @RequestParam(required = false) String search) {
		
		  Sort sort = null;
	        if(sortDir.equalsIgnoreCase("ASC")) {
	            sort = Sort.by(sortBy).ascending();
	        } else {
	            sort = Sort.by(sortBy).descending();
	        }
		
		return service.findAllEmployees(PageRequest.of(pageNo-1, pageSize, sort), search);
	}
}
