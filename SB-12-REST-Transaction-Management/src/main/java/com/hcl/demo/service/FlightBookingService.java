package com.hcl.demo.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.demo.dto.FlightBookingRequest;
import com.hcl.demo.dto.FlightBookingResponse;
import com.hcl.demo.entity.PassengerInfo;
import com.hcl.demo.entity.PaymentInfo;
import com.hcl.demo.repository.PassengerInfoRepo;
import com.hcl.demo.repository.PaymentInfoRepo;
import com.hcl.demo.util.PaymentUtil;

@Service
public class FlightBookingService {

	@Autowired
	private PassengerInfoRepo passengerInfoRepo;
	@Autowired
	private PaymentInfoRepo paymentInfoRepo;
	
	  @Transactional
	  public FlightBookingResponse bookFlightTicket(FlightBookingRequest bookingRequest) {
		  FlightBookingResponse bookingResponse=null;
		  PassengerInfo passengerInfo =  bookingRequest.getPassengerInfo();
		  passengerInfo = passengerInfoRepo.save(passengerInfo);
		  
		  PaymentInfo paymentInfo =  bookingRequest.getPaymentInfo();
		  
		  PaymentUtil.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());
		  
		  paymentInfo.setPassengerId(passengerInfo.getpId());
		  paymentInfo.setAmount(passengerInfo.getFare());
		  paymentInfoRepo.save(paymentInfo);
		  
		  return new FlightBookingResponse("SUCCESS",passengerInfo.getFare(),
				  UUID.randomUUID().toString().split("-")[0],passengerInfo);
	  }
}
