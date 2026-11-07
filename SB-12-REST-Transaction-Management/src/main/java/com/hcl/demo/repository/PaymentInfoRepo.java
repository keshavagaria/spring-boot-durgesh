package com.hcl.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.demo.entity.PaymentInfo;

public interface PaymentInfoRepo extends JpaRepository<PaymentInfo, String> {

}
