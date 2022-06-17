//StudentOperationsController.java
package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student/api")
public class StudentOperationsController {
	
	@GetMapping("/report/{sno}/{sname}")
	  public   ResponseEntity<String>  showReport1(@PathVariable(name = "sno",required = false) Integer no,
			                                                                                    @PathVariable(required = false) String sname){
		   return  new ResponseEntity<String>("from ShowReport1 ",HttpStatus.OK);
	}
	
	@GetMapping("/report/101/raja")
	  public   ResponseEntity<String>  showReport2(@PathVariable(name = "sno",required = false) Integer no,
			                                                                                    @PathVariable(required = false) String sname){
		   return  new ResponseEntity<String>("from ShowReport2 ",HttpStatus.OK);
	}
	
	@GetMapping("/report/101/raja")
	  public   ResponseEntity<String>  showReport3(@PathVariable(name = "sno",required = false) Integer no,
			                                                                                    @PathVariable(required = false) String sname){
		   return  new ResponseEntity<String>("from ShowReport3 ",HttpStatus.OK);
	}
}
