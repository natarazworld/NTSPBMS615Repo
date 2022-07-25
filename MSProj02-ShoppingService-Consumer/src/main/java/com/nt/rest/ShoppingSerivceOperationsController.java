//ShoppingSerivceOperationsController.java (RestController)
package com.nt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.BillingServiceCosumerClient;

@RestController
@RequestMapping("/shopping/api")
public class ShoppingSerivceOperationsController {
	 @Autowired
	private BillingServiceCosumerClient client;

	 @GetMapping("/cart")
	  public   ResponseEntity<String>  doShopping(){
		  //use  Client Comp
		  String  resultMsg=client.getBillingInfo();
		  return  new ResponseEntity<String>("Shopping the items(shirt,trouser) ::::"+resultMsg,HttpStatus.OK);
		  
		  
	  }
	  
}
