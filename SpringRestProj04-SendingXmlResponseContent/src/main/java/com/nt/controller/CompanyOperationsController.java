//CompanyOperationsController.java
package com.nt.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Company;

@RestController
@RequestMapping("/company/api")
public class CompanyOperationsController {
	
	@GetMapping("/show")
	public   ResponseEntity<Company>   showCompanyDetails(){
		  Company company=new Company("HCL", "hyd", 100,500000000.0, "IT");
		  //  create and return ResponseEntity obj having model class obj as the response body/content
		   return  new ResponseEntity<Company>(company, HttpStatus.OK);
	}
	
	
	@GetMapping("/show1")
	public   ResponseEntity<Company>   showCompanyDetails1(){
		  Company company=new Company("HCL", "hyd", 100,500000000.0, "IT");
		  //  create and return ResponseEntity obj having model class obj as the response body/content
		   return  new ResponseEntity<Company>(company, HttpStatus.OK);
	}

}
