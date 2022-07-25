//ShoppingSerivceOperationsController.java (RestController)
package com.nt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.BillingServiceConsumerClient;

@RestController
@RequestMapping("/shopping/api")
public class ShoppingSerivceOperationsController {
	 @Autowired
	private BillingServiceConsumerClient client;

	 @GetMapping("/cart")
	  public   ResponseEntity<String>  doShopping(){
		  //use  Client Comp
		  String  resultMsg=client.getBillingInfo();
		  try {
			  Thread.sleep(20000);
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  return  new ResponseEntity<String>("Shopping the items(shirt,trouser) ::::"+resultMsg,HttpStatus.OK);
		  
		
			  
		  
		  
	  }
	  
}
