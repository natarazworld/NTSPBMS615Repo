package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeOperationsController {
	@Autowired
	private IEmployeeMgmtService service;
	
	@GetMapping("/")
	public  String showHomePage() {
		//return LVN
		return "welcome";
	}
	
	@GetMapping("/report")
	public  String  showReport(Map<String,Object> map,
			                                        @RequestParam("type") String type) {
		//use  service
		List<Employee> empsList=service.getAllEmployees();
		// add results to model attribute
		map.put("empsList", empsList);
		//return lvn based on the hyperlink that is clicked
		 if(type.equalsIgnoreCase("excel")) 
			 return  "excel_report";
		 else 
			 return "pdf_report";
		 
	}

}
