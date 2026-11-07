package com.hcl.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.hcl.demo.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

}
