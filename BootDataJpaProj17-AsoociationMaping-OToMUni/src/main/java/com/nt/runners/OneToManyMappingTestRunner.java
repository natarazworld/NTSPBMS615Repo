package com.nt.runners;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.service.IOneToManyMappingMgmtService;


@Component
public class OneToManyMappingTestRunner implements CommandLineRunner {
	@Autowired
	private  IOneToManyMappingMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		 //prepare child objects
		 PhoneNumber ph=new PhoneNumber();
		 ph.setContactNo(999999999L); ph.setNumberType("office");
		 ph.setProvider("airtel");
		 PhoneNumber ph1=new PhoneNumber();
		 ph1.setContactNo(88888888L); ph1.setNumberType("residence");
		 ph1.setProvider("VI");
		 //prpeare parent object
		 Person  per=new Person();
		 per.setPname("raja"); per.setPaddrs("hyd");
		 per.setPhonesInfo(Set.of(ph,ph1));
		 try {
			 //invoke method
			 System.out.println(service.saveDataUsingParent(per));
		 }//try
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 
		 
		

	}

}
