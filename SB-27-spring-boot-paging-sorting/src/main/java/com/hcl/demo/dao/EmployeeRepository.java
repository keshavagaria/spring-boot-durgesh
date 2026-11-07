package com.hcl.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Page<Employee> findByName(String search, Pageable pageable);

}
