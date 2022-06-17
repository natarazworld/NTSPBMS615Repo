 //EmployeeOperationsController.java
package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Company;
import com.nt.model.Employee;

@RestController
@RequestMapping("/employee/api")
public class EmployeeOperationsController {
	
	@PostMapping("/register")
	public ResponseEntity<Employee>  registerEmployee(@RequestBody Employee emp){
		System.out.println("EmployeeOperationsController.registerEmployee():::"+emp);
		return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
	}
	
	
	
	@PostMapping("/company")
	public ResponseEntity<Company>  registerCompany(@RequestBody Company company){
		System.out.println("EmployeeOperationsController.registerCompany():::"+company);
		return new ResponseEntity<Company>(company,HttpStatus.CREATED);
	}
	

}
