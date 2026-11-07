package com.hcl.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
