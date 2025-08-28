package com.hcl.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.demo.entity.Address;
import com.hcl.demo.entity.Employee;
import com.hcl.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;
	@Autowired
	private AddressService addressService;
	
	@Transactional(rollbackFor = Exception.class)
	public Employee addEmployee(Employee employee) throws Exception {
		
		Employee savedEmployee = empRepository.save(employee);

		if(savedEmployee.getName().equals("Ramesh")) {
			throw new Exception();
		}
		
		Address address=new Address();
		address.setId(110085);
    	address.setCity("Kohat Enclave");
    	address.setState("Delhi");
    	address.setEmployee(savedEmployee);
    	
    	addressService.addAddressToo(address);
    	System.out.println("Employee Service is running...");
    	
		return savedEmployee;
	}

	
}
