package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.model.UserDetails;
import com.nt.service.IUserRegistrationService;

@Controller
@RequestMapping("/user")
public class UserRegistrationOperationsController {
	@Autowired
	private IUserRegistrationService  userService;
	
	// handler method to show the form page
	@GetMapping("/register")
	public String   showUserForm(@ModelAttribute("userInfo") UserDetails details) {
		return "user_registration";
	}
	
	//  handler method to process the form submission
	@PostMapping("/register")
	public  String  processRegisterUser(Map<String,Object> map, @ModelAttribute("userInfo") UserDetails details) {
		 //use service
		String msg=userService.registerUser(details);
		// keep the message in model attributes
		map.put("resultMsg",msg);
		//return LVN
		return "user_registration_success";
	}
	
	@GetMapping("/showLogin")
	public  String  showLoginPage() {
		 //  return LVN
	   return "custom_login";	
	}

}
