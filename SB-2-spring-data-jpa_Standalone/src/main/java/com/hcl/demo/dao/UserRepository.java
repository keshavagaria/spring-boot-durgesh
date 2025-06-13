package com.hcl.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hcl.demo.entity.UserDetails;

public interface UserRepository extends CrudRepository<UserDetails, Integer>{

	public List<UserDetails> findByName(String name);
	
	public List<UserDetails> findByNameAndCity(String name,String city);
	
	//JPQL
	@Query("SELECT u FROM UserDetails u")
	public List<UserDetails> getAllUsers();
	
	@Query("SELECT u FROM UserDetails u where u.name= :n")
	public List<UserDetails> getUserByName(@Param("n")String name);
	
	@Query("SELECT u FROM UserDetails u where u.name= :n and u.city= :c")
	public List<UserDetails> getUserByNameAndCity(@Param("n")String name,
												  @Param("c") String city);
	
	
	//native Query
	@Query(value = "SELECT * FROM User_Details",nativeQuery = true)
	public List<UserDetails> getUsers();
	
	
}
