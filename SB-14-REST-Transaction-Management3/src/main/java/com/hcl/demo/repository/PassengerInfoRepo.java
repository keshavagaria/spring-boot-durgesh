package com.hcl.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.demo.entity.PassengerInfo;

public interface PassengerInfoRepo extends JpaRepository<PassengerInfo, Long>{

}
