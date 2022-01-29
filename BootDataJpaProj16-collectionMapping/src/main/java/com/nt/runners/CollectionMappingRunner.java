package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IEmployeeMgmtService;

@Component
public class CollectionMappingRunner implements CommandLineRunner {
	@Autowired
	private IEmployeeMgmtService service;

	@Override
	public void run(String... args) throws Exception {
	   //save object
/*		try {
			//prepare object
			 EmployeeInfo info=new EmployeeInfo(123, "raja", 
					                                                                List.of("rani","ravi","suresh"),
					                                                                Set.of(99999L,88888L),
					                                                                Map.of("aadhar","5453535","voterId","45354555")
					                                                                );
			 System.out.println(service.registerEmployee(info));
		}//try
		catch(Exception e) {
			e.printStackTrace();
		} */
		System.out.println("---------------all  emp ---details are--------------");
		service.getAllEmpDetails().forEach(System.out::println);

	}//main

}//class
