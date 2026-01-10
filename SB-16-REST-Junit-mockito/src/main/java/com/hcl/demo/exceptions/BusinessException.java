package com.hcl.demo.exceptions;

public class BusinessException {

	private String errorCode;
	private String errorMsg;
	
	public BusinessException(String errorCode, String errorMsg) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	
	
	
}
