package com.nt.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.IWishService;

@Controller
public class WishMessageOperationsController {
	@Autowired
	private IWishService  service;
	
	@RequestMapping("/home")
	public  String showHomePage() {
		//return LVN
		return "welcome";
	}
	
	/*@RequestMapping("/wish")
	public  ModelAndView   fetchWishMessage() {
		//use service
		String  msg=service.generateWishMessage();
		//keep results and other data as Model attributes in MAV object
		ModelAndView mav=new ModelAndView();
		mav.addObject("wMsg", msg);  //attr name ,  value
		mav.addObject("sysDate", new Date());  //atrt name, value
		mav.setViewName("show_result");
		//return MAV
		return mav;
	}*/
	
	/*@RequestMapping("/wish")
	public  String   fetchWishMessage(HashMap<String,Object> map) {
		System.out.println("shared Memory obj class name::"+map.getClass());
		//use service
		String  msg=service.generateWishMessage();
		 //  keep  data in model attributes
		 map.put("wMsg",msg);
		 map.put("sysDate",new Date());
		//return MAV
		return "show_result";
	}
	*/
	
	
	/*@RequestMapping("/wish")
	public  String   fetchWishMessage(Model model) {
		System.out.println("shared Memory obj class name::"+model.getClass());
		//use service
		String  msg=service.generateWishMessage();
		 //  keep  data in model attributes
		model.addAttribute("wMsg", msg);
		model.addAttribute("sysDate",new Date());
		//return MAV
		return "show_result";
	}*/
	
	/*@RequestMapping("/wish")
	public  String   fetchWishMessage(ModelMap map) {
		System.out.println("shared Memory obj class name::"+map.getClass());
		//use service
		String  msg=service.generateWishMessage();
		 //  keep  data in model attributes
		map.addAttribute("wMsg", msg);
		map.addAttribute("sysDate",new Date());
		//return MAV
		return "show_result";
	}
	*/
	
	/*@RequestMapping("/wish")
	public  String   fetchWishMessage(Map<String,Object> map) {
		System.out.println("shared Memory obj class name::"+map.getClass());
		//use service
		String  msg=service.generateWishMessage();
		 //  keep  data in model attributes
		map.put("wMsg", msg);
		map.put("sysDate",new Date());
		//return MAV
		return "show_result";
	}*/
	
	/*@RequestMapping("/wish")
	public  ModelMap   fetchWishMessage() {
		//use service
		String  msg=service.generateWishMessage();
		 //  keep  data in model attributes
		ModelMap map=new BindingAwareModelMap();
		map.put("wMsg", msg);
		map.put("sysDate",new Date());
		//return MAV
		return  map;
	}*/
	
	
	/*@RequestMapping("/wish")
	public  Model   fetchWishMessage() {
		//use service
		String  msg=service.generateWishMessage();
		 //  keep  data in model attributes
		Model model=new BindingAwareModelMap();
		model.addAttribute("wMsg", msg);
		model.addAttribute("sysDate", new Date());
		//return MAV
		return  model;
	}*/
	
	/*@RequestMapping("/wish")
	public  Map<String,Object>   fetchWishMessage() {
		//use service
		String  msg=service.generateWishMessage();
		 //  keep  data in model attributes
		Map<String,Object> map=new HashMap();
	 map.put("wMsg", msg);
		map.put("sysDate", new Date());
		//return MAV
		return  map;
	}*/
	
	@RequestMapping("/wish")
	public  void   fetchWishMessage(Map<String,Object> map) {
		//use service
		String  msg=service.generateWishMessage();
		 //  keep  data in model attributes
	 map.put("wMsg", msg);
		map.put("sysDate", new Date());
	}
	

}
