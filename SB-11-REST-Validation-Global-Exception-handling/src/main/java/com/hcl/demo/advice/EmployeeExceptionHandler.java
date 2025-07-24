package com.hcl.demo.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmployeeExceptionHandler {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		
		Map<String,String > errorMap=new HashMap<>();
		
		ex.getBindingResult().getFieldErrors().forEach(error->{
			
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return new ResponseEntity<Object>(errorMap,HttpStatus.BAD_REQUEST);
	}

	
}
