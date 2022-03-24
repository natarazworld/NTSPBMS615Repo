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
	
	
	@GetMapping("/all")
	public   String  showAllData() {
		System.out.println("WishMessageOperationsController.showAllData()");
	  return "show_report";
	}
	
	/*@GetMapping
	public  String showHomePage1(ServletContext sc, ServletConfig cg, HttpSession ses) {
		System.out.println("WishMessageOperationsController.showHomePage1()");
		
		System.out.println(" web application's name::"+sc.getContextPath());
		  System.out.println("session id::"+ses.getId());
		  System.out.println("DS logical name::"+cg.getServletName());
		
		//return LVN
		return  "redirect:all";
	}*/
	
	@GetMapping
	public  String showHomePage1(HttpSession ses) {
		System.out.println("WishMessageOperationsController.showHomePage1()");
		
		  System.out.println("session id::"+ses.getId());
		//return LVN
		return  "redirect:all";
	}

	
	/*@PostMapping
	public  String showHomePage2() {
		//return LVN
		return "welcome";
	}*/
	
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
	
	/*@RequestMapping("/wish")
	public  void   fetchWishMessage(Map<String,Object> map) {
		//use service
		String  msg=service.generateWishMessage();
		 //  keep  data in model attributes
	 map.put("wMsg", msg);
		map.put("sysDate", new Date());
	}*/
	
	
	@RequestMapping("/wish")
	public String   fetchWishMessage(Map<String,Object> map) {
		//use service
		String  msg=service.generateWishMessage();
		 //  keep  data in model attributes
	 map.put("wMsg", msg);
		map.put("sysDate", new Date());
		return null;
	}
	
	
	/*@RequestMapping("/wish")
	public String   fetchWishMessage(HttpServletResponse res) throws Exception{
		//use service
		String msg=service.generateWishMessage();
		
		//get PrintWriter from response obj
	     PrintWriter pw=res.getWriter();
	     //write output to response object
	     pw.println("<b> wish message is ::"+msg+"</b><br>");
	     pw.println("<br> sys date and time ::"+new Date()+"</b>");
		 return null;
	}*/
	
	
	/*@RequestMapping({"/report1","/report3","/report2"})
	public String   showReport() throws Exception{
		System.out.println("WishMessageOperationsController.showReport()");
		return "show_report";
	}
	
	@RequestMapping("/REPORT")
	public String   showReport1() throws Exception{
		System.out.println("WishMessageOperationsController.showReport1()");
		return "show_report1";
	}
	*/
	
	
	/*//@RequestMapping(value="/report",method=RequestMethod.GET) (or)
	@GetMapping("/report")
	public String   showReport() throws Exception{
		System.out.println("WishMessageOperationsController.showReport()");
		return "show_report";
	}
	
	//@RequestMapping(value="/report", method=RequestMethod.POST)
	@GetMapping("/report")
	public String   showReport1() throws Exception{
		System.out.println("WishMessageOperationsController.showReport1()");
		return "show_report1";
	}*/
	

}
