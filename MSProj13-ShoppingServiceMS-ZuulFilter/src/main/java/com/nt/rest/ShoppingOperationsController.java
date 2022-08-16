//ShoppingOperationsController
package com.nt.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/shoppingMs")
public class ShoppingOperationsController {
	@Autowired
	private RestTemplate template;
		
	
		@GetMapping("/shopping")
	public  String   doShopping() {
		 
		 // invoke the method  another  micro service (BillingOperationsController -MS)
		 String msg=template.getForObject("http://localhost:9092/BillingMs/billing", String.class);  // Intra Ms Communication
		
		 return  "Shopping Operation :"+msg;
		
	}//method

}//class
