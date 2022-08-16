//BillingOperationsController
package com.nt.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/BillingMs")
public class BillingOperationsController {
	@Autowired
	private RestTemplate template;
		
	
		@GetMapping("/billing")
	public  String   doBilling() {
		
		 // invoke the method  another  micro service (PaymentOperationsController -MS)
		 String msg=template.getForObject("http://localhost:9093/PaymentMs/payment", String.class);  // Intra Ms Communication
	
		 return  "Bill Amount :90000 :"+msg;
		
	}//method

}//class
