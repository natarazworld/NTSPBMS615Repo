//PaymentOperationsController
package com.nt.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/PaymentMs")
public class  PaymentOperationsController {

		Logger logger=LoggerFactory.getLogger(PaymentOperationsController.class);
	
		@GetMapping("/payment")
	public  String   doPayment() {
		 logger.info("PaymentOperationsController::  payment operation just started");   
			 logger.info("Payment Operation is completed");
		 return  "Payment is done using PhonePe UI";
		
	}//method

}//class
