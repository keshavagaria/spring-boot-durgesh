package com.hcl.demo.dto;

import com.hcl.demo.entity.PassengerInfo;

public class FlightBookingResponse {

	 	private String status;
	    private double totalFare;
	    private String pnrNo;
	    private PassengerInfo passengerInfo;
		
	    public FlightBookingResponse() {
			super();
			// TODO Auto-generated constructor stub
		}
		public FlightBookingResponse(String status, double totalFare, String pnrNo, PassengerInfo passengerInfo) {
			super();
			this.status = status;
			this.totalFare = totalFare;
			this.pnrNo = pnrNo;
			this.passengerInfo = passengerInfo;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public double getTotalFare() {
			return totalFare;
		}
		public void setTotalFare(double totalFare) {
			this.totalFare = totalFare;
		}
		public String getPnrNo() {
			return pnrNo;
		}
		public void setPnrNo(String pnrNo) {
			this.pnrNo = pnrNo;
		}
		public PassengerInfo getPassengerInfo() {
			return passengerInfo;
		}
		public void setPassengerInfo(PassengerInfo passengerInfo) {
			this.passengerInfo = passengerInfo;
		}
	    
	    
}
