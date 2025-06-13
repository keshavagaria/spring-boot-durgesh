package com.hcl.demo.service;

import java.awt.print.Book;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.demo.dao.EmployeeRepository;
import com.hcl.demo.entity.Employee;
import com.hcl.demo.exception.BusinessException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;
	
	public List<Employee> getAllEmployees() {
		List<Employee> empList=null;
		try {
			empList=(List)empRepository.findAll();
		}catch(Exception e) {
			throw new BusinessException("605","Something wrong in service layer while fetching list!!!"+e.getMessage() );
		}
			if(empList.isEmpty()) {
				throw new BusinessException("604","List is all empty!!!");
			}
			return empList;
		
	}
	
	public Optional<Employee> getEmployeeById(int id) {
		try {
			Optional<Employee> emp=empRepository.findById(id);
			if(emp.isEmpty()) {
				throw new BusinessException("606","Given Book id don't exist in DB!!!");
			}
		return emp;
		}catch (NoSuchElementException e) {
			throw new BusinessException("607","No Such Element Present");
		}
	}
	
	public void addEmployee(Employee emp) {
		
			if(emp.getName().isEmpty() || emp.getName().length()==0) {
				throw new BusinessException("601","Book Author name is null. Please correct it");
			}
			empRepository.save(emp);
			
		
	}

	public void deleteEmployeeById(int id) {
		try {
			empRepository.deleteById(id);
		}catch(IllegalArgumentException e) {
			throw new BusinessException("608","Book id is null!!!");
		}
		
	}

	

	public void updateEmployee(Employee emp, int id) {
		
		empRepository.save(emp);
	}
}
