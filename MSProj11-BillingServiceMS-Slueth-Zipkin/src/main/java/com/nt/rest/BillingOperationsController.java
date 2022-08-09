//BillingOperationsController
package com.nt.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
		Logger logger=LoggerFactory.getLogger(BillingOperationsController.class);
	
		@GetMapping("/billing")
	public  String   doBilling() {
		 logger.info("BillingOperationsController::  billing operation just started");   
		 // invoke the method  another  micro service (PaymentOperationsController -MS)
		 String msg=template.getForObject("http://localhost:9093/PaymentMs/payment", String.class);  // Intra Ms Communication
		 logger.info(" Payment service is invoked");
		 logger.info("Back to Billing SErvice");
		 return  "Bill Amount :90000 :"+msg;
		
	}//method

}//class
