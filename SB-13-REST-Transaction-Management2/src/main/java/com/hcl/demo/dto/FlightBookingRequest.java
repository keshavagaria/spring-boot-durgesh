package com.hcl.demo.dto;

import com.hcl.demo.entity.PassengerInfo;
import com.hcl.demo.entity.PaymentInfo;

public class FlightBookingRequest {

	private PassengerInfo passengerInfo;
	private PaymentInfo paymentInfo;
	
	
	public FlightBookingRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FlightBookingRequest(PassengerInfo passengerInfo, PaymentInfo paymentInfo) {
		super();
		this.passengerInfo = passengerInfo;
		this.paymentInfo = paymentInfo;
	}


	public PassengerInfo getPassengerInfo() {
		return passengerInfo;
	}


	public void setPassengerInfo(PassengerInfo passengerInfo) {
		this.passengerInfo = passengerInfo;
	}


	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}


	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
	
	
	
}
