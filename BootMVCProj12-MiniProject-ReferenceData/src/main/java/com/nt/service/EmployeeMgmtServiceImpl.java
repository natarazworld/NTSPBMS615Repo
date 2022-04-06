package com.nt.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repo.IEmployeeRepo;


@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepo empRepo;

	

	@Override
	public String registerEmployee(Employee emp) {
       int idVal=empRepo.save(emp).getEmpno();
		return "Employee is saved with the id value ::"+idVal; 
	}

	@Override
	public Employee getEmployeeByNo(int no) {
		Employee emp=empRepo.findById(no).get();
		return emp;
	}

	@Override
	public String editEmployee(Employee emp) {
	       int idVal=empRepo.save(emp).getEmpno();  //save(-)  method can perform both save /edit operations
			return idVal+" Employee is updated "; 

	}
	
	@Override
	public String deleteEmployee(int no) {
		  empRepo.deleteById(no);
		  return no+" emp no Employee is deleted";
	}

	@Override
	public Page<Employee> getEmployeesPageData(Pageable pageable) {
	        Page<Employee> page=empRepo.findAll(pageable);
		return page;
	}
	
	@Override
	public Set<String> getAllCountries() {
		  // get All Locales of the world
		Locale locales[]=Locale.getAvailableLocales();
		Set<String> countrySet=new TreeSet();
		for(Locale l:locales) {
			if(l!=null)
			   countrySet.add(l.getDisplayCountry());
		}
		return countrySet;
	}//method

	
	@Autowired
	private  Environment  env;
	
	@Override
	public List<String> getStatesByCountry(String country) {
		// get  states of  a country through Environment obj  
		String statesInfo=env.getRequiredProperty(country);
		//convert  comma seperated values into List colelction using  "," as delimeter
		 List<String> statesList=Arrays.asList(statesInfo.split(","));
		 // sort collection
		   Collections.sort(statesList);
		  return statesList;  
	}
	
	
	

}
