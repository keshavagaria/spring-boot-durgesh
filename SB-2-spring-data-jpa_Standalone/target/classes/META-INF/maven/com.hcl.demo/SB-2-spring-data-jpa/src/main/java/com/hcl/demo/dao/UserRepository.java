package com.hcl.demo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hcl.demo.entity.User_Details;

public interface UserRepository extends CrudRepository<User_Details, Integer>{

	public List<User_Details> findByName(String name);
	
	public List<User_Details> findByNameAndCity(String name,String city);
	
	//JPQL
	@Query("SELECT u FROM User_Details u")
	public List<User_Details> getAllUsers();
	
	@Query("SELECT u FROM User_Details u where u.name= :n")
	public List<User_Details> getUserByName(@Param("n")String name);
	
	@Query("SELECT u FROM User_Details u where u.name= :n and u.city= :c")
	public List<User_Details> getUserByNameAndCity(@Param("n")String name,
												  @Param("c") String city);
	
	
	//native Query
	@Query(value = "SELECT * FROM User_Details where name = :n",nativeQuery = true)
	public List<User_Details> getUsers(@Param("n") String name);
	
//	@Query(value = "SELECT * FROM User_Details where name = ?1",nativeQuery = true)
//	public List<User_Details> getUsers(String name);
	
	// named query
	@Query(name = "getUserDetailsByStatus")
	public List<User_Details> getUsersbyStatus(String status);
	
	@Query(name = "getUserDetailsByCity")
	public List<User_Details> getUsersbyCity(String city);
	
	@Query(name = "getUserDetailsByCityStatus",nativeQuery = true)
	public List<User_Details> getUsersbyCityStatus(String city, String status);
	
}
