package com.nt.rest;

import java.security.Principal;
import java.util.Random;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserOperationsController {
	
	@GetMapping("/home")
	public  String  showHome() {
		return " <h1> welcome to home page of  IndiaBus.com </h1>";
	}
	
	@GetMapping("/balance")
	public  String  showBalance() {
		 int balanceAmount=new Random().nextInt(10000);
		return " <h1> Successfully Logged into  IndiaBus.com :::"+balanceAmount +"</h1>";
	}
	
	@GetMapping("/user")
	public  Authentication  showUserDetails(Principal  principle) {
		  System.out.println("currently logged FB user name::"+principle.getName());
		Authentication  auth=SecurityContextHolder.getContext().getAuthentication();
		return auth;
		
	}

}
