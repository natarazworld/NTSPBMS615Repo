package com.nt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY) // 422
public class EmployeeNotFoundException extends RuntimeException {
	
	public EmployeeNotFoundException(String msg) {
		 super(msg);
		System.out.println("EmployeeNotFoundException:: 0-param constructor");
		
	}

}
