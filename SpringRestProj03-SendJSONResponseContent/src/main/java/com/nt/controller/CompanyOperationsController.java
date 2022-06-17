//CompanyOperationsController.java
package com.nt.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Company;
import com.nt.model.Employee;

@RestController
@RequestMapping("/company/api")
public class CompanyOperationsController {
	
	/*@GetMapping("/show")
	public   ResponseEntity<Company>   showCompanyDetails(){
		  Company company=new Company("HCL", "hyd", 100,500000000.0, "IT");
		  //  create and return ResponseEntity obj having model class obj as the response body/content
		   return  new ResponseEntity<Company>(company, HttpStatus.PARTIAL_CONTENT);
	}*/
	
	
	/*@GetMapping("/show")
	public   Company   showCompanyDetails(){
		  //  create and return model class obj
		  Company company=new Company("HCL", "hyd", 100,500000000.0, "IT");
		   return   company;
	}*/
	
	
	@GetMapping("/showall")
	public   ResponseEntity<Employee>   showCompanyDetails(){
		  Company company=new Company("HCL", "hyd", 100,500000000.0, "IT");
		  Employee emp=new Employee(1001,
				                                                      "Raja",
				                                                      new String[] {"red","green","blue"}, //java 9 features
		                                                              List.of("king","maharaja","sultan"),//java 9 features
		                                                              Set.of(999999L ,888888L), //java 9 features
		                                                              Map.of("aadhar",99995454L,"voterID",554354534L),  //java 9 features
		                                                                false, 
		                                                                LocalDateTime.of(1990, 10, 12,13, 30),
		                                                                company); 
		  
		  //  create and return ResponseEntity obj having model class obj as the response body/content
		   return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	

}
