package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nt.model.Customer;

@Controller
public class CustomerOperationsController {
	
	@GetMapping("/")
	public String showHome() {
		 //return  LVN
		return "welcome";
	}
	
	@GetMapping("/register")
	public  String  showCustomerFormPage(@ModelAttribute("cust") Customer cust,
			                                                             Map<String,Object> map) {
		//return LVN
		return  "customer_register";
		
		
	}

}
