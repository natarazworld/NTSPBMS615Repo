package com.nt.controller;


import java.util.Date;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.IWishService;

@Controller
public class WishMessageOperationsController {
	@Autowired
	private IWishService  service;
	
	
	@GetMapping("/")
	public   String  showHomePage() {
	System.out.println("WishMessageOperationsController.showHomePage()");
	  return "welcome";
	}
	
	
	@GetMapping("/wish")
	public  String   fetchWishMessage(Map<String,Object> map) {
		//use service
		String  msg=service.generateWishMessage();
		 //  keep  data in model attributes
		map.put("wMsg", msg);
		map.put("sysDate",new Date());
		//return MAV
		return "show_result";
	}
	
		

}
