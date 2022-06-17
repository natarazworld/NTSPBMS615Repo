//CustomerOperationsController.java
package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer/api")
public class CustomerOperationsController {
	
	@PostMapping("/report")
	public  ResponseEntity<String>  showReport( @RequestParam String cname,@RequestParam("cno") int no){
		System.out.println(cname+"  "+no);
		return new ResponseEntity<String>(cname+" "+no,HttpStatus.OK);
	}

}
