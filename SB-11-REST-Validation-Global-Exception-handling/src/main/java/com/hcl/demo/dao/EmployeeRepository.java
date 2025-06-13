package com.hcl.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.demo.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
