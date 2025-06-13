package com.hcl.demo.entity;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PAYMENT_INFORMATION")
public class PaymentInfo {

		@Id
		@GeneratedValue(generator = "uuid2")
		@GenericGenerator(name = "uuid2",strategy = "org.hibernate.id.UUIDGenerator")
		private String paymentId;
	    private String accountNo;
	    private double amount;
	    private String cardType;
	    private Long passengerId;
	    
		public String getPaymentId() {
			return paymentId;
		}
		public void setPaymentId(String paymentId) {
			this.paymentId = paymentId;
		}
		public String getAccountNo() {
			return accountNo;
		}
		public void setAccountNo(String accountNo) {
			this.accountNo = accountNo;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public String getCardType() {
			return cardType;
		}
		public void setCardType(String cardType) {
			this.cardType = cardType;
		}
		public Long getPassengerId() {
			return passengerId;
		}
		public void setPassengerId(Long passengerId) {
			this.passengerId = passengerId;
		}
	    
	    
}
