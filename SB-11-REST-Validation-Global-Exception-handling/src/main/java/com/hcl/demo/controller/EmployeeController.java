package com.hcl.demo.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.demo.entity.Employee;
import com.hcl.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees() {
		
		List<Employee> empList=empService.getAllEmployees();
		if(empList.size()==0) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(empList));
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable int id) {
		
			Optional<Employee> emp=empService.getEmployeeById(id);
			if(emp.isPresent()) {
				return new ResponseEntity<>(emp.get(),HttpStatus.OK);

		}
			return new ResponseEntity<>("Sorry Employee with given id is not present!!!",HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> addNewEmployee( @Valid @RequestBody  Employee emp) {
		
			empService.addEmployee(emp);
			return ResponseEntity.status(HttpStatus.CREATED).body(emp);
	}
	
	
	@DeleteMapping("/employees/{empId}")
	public ResponseEntity<Void> deleteBookById(@PathVariable("bookId")  int id) {
		try {
			empService.deleteEmployeeById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@PutMapping("/employees/{empId}")
	public ResponseEntity<Employee> updateTheBook(@RequestBody Employee emp,
							  @PathVariable("empId")  int id) {
		try {
			empService.updateEmployee(emp, id);
			return ResponseEntity.ok().body(emp);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
