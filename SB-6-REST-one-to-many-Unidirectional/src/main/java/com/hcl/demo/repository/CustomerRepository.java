package com.hcl.demo.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hcl.demo.dto.OrderResponse;
import com.hcl.demo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Query("SELECT new com.hcl.demo.dto.OrderResponse(c.name, p.productName) FROM Customer c JOIN c.products p")
	public List<OrderResponse> getJoinInformation();
	
	@Query("SELECT c FROM Customer c JOIN c.products p WHERE c.id = :id")
	public Optional<Customer> findCustomerById(@Param("id") int id);
	
	// N+1 problem solution -
	// 1.
	@Query("SELECT c FROM Customer c LEFT JOIN FETCH c.products")
	public List<Customer> findNPlusOneSolved();
//	
	// 2.
    @EntityGraph(attributePaths = {"products"})
	public List<Customer> findAll();
}
