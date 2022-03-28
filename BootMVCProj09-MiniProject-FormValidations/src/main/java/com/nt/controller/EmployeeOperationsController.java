package com.nt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;
import com.nt.validations.EmployeeValidator;

@Controller
public class EmployeeOperationsController {
	@Autowired
	private IEmployeeMgmtService service;
	@Autowired
	private EmployeeValidator  empValidator;
	
	@GetMapping("/")
   public  String showHome() {
		return "home";
	}
	
	@GetMapping("/report")
	public  String  showEmployeeReport(Map<String,Object> map) {
		System.out.println("EmployeeOperationsController.showEmployeeReport()");
		  //use serivce
		List<Employee> list=service.getAllEmployees();
		// put the results in model attributes
		map.put("empsData",list);
		//return LVN
		return "employee_report";
	}//method
	
	@GetMapping("/add")
	public String showAddEmployeeForm(@ModelAttribute("emp") Employee emp) {
		System.out.println("EmployeeOperationsController.showAddEmployeeForm()");
		   emp.setJob("CLERK");  //intial value to display in form comp as initial value
		   //return lvn
		   return "employee_register";
	}
	
	
	
	@PostMapping("/add")
	public String addEmployee(RedirectAttributes attrs,
			                                        @ModelAttribute("emp") Employee emp,
			                                        BindingResult  errors) {
	
		System.out.println("EmployeeOperationsController.addEmployee()");
          //checking for type mismatch errors
		  if(errors.hasFieldErrors())
		  	  return "employee_register";
		
		  //checking form validation errors
    if(empValidator.supports(emp.getClass())) {
			 empValidator.validate(emp, errors); //T
			 if(errors.hasErrors())
				 return "employee_register";
		}
    
      //application logic errors
        if(emp.getJob().equalsIgnoreCase("hacker")) {
        	errors.rejectValue("job", "job.reject");
        	return "employee_register";
        }
        	  
    
		//use service
	   String result=service.registerEmployee(emp);
	   //keep results in model attributes (RedirectAttributes)
	   attrs.addFlashAttribute("resultMsg", result);
	   //return LVN
	   return "redirect:report";
		
	}
	
		
	@GetMapping("/edit")
	public String  showEditEmployeeForm(@RequestParam("no") int no,
			                                                           @ModelAttribute("emp") Employee emp) {
		//get Employee details dyamically based on the given emp no
		 Employee emp1=service.getEmployeeByNo(no);
		 //emp=emp1;
		 BeanUtils.copyProperties(emp1, emp);
		 //return lvn
		 return "employee_edit";
	}
	
	
	@PostMapping("/edit")
	public String  EditEmployee(@ModelAttribute("emp") Employee emp,
			                                          RedirectAttributes attrs,
			                                          BindingResult errors) {
		 //checking for type mismatch errors
		  if(errors.hasFieldErrors())
		  	  return "employee_edit";
		
		  //checking form validation errors
  if(empValidator.supports(emp.getClass())) {
			 empValidator.validate(emp, errors); //T
			 if(errors.hasErrors())
				 return "employee_edit";
		}
  
      if(emp.getJob().equalsIgnoreCase("hacker")) {
      	errors.rejectValue("job", "job.reject");
      	return "employee_edit";
      }
		//use  service
		 String msg=service.editEmployee(emp);
		 //keep results  as flashAttributes attributes in Redirect scope
		  attrs.addFlashAttribute("resultMsg", msg);
		//return lvn
		   return "redirect:report";
	}
	
	
	@GetMapping("/delete")
	public String  deleteEmployee(@RequestParam("no") int no,
			                                              RedirectAttributes attrs) {
		//use service
		String msg=service.deleteEmployee(no);
		 //keep results in model attributes
		   attrs.addFlashAttribute("resultMsg", msg);
		//return lvn
		   return "redirect:report";
	}

	
}//class
