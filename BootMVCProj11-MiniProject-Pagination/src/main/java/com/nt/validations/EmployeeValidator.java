package com.nt.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.model.Employee;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Employee.class);  //checks wheather we are passing
		                                                                                   //correct model class or not
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("EmployeeValidator.validate()(server side form validations)");
		//type casting
		Employee emp=(Employee)target;
		//form validation logics
		  //required rule  ename
		if(emp.getEname()==null || emp.getEname().length()==0 || emp.getEname().equals(""))
		     errors.rejectValue("ename","empname.required");
		   //max length ename
		else if(emp.getEname().length()>10)
			errors.rejectValue("ename","empname.maxlength");
		
		  //required rule  job
		if(emp.getJob()==null || emp.getJob().length()==0 || emp.getJob().equals(""))
		     errors.rejectValue("job","empdesg.required");
		   //max length  job
		else if(emp.getJob().length()>9)
			errors.rejectValue("job","empdesg.maxlength");
		
		  //required rule  sal
		if(emp.getSal()==null ) 
		     errors.rejectValue("sal","empsal.required");
		else if(emp.getSal()<1 || emp.getSal()>100000)
			errors.rejectValue("sal","empsal.range");
	}

}
