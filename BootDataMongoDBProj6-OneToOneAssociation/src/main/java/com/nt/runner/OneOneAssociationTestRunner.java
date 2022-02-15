package com.nt.runner;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.DrivingLicense;
import com.nt.document.Person;
import com.nt.service.IRTOMgmtService;

@Component
public class OneOneAssociationTestRunner implements CommandLineRunner {
	@Autowired
	private  IRTOMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		/*  //parent to child 
		try { 
			 Person per=new Person("raja","hyd");
			 DrivingLicense license=new DrivingLicense(5654645L,"2-wheeler",LocalDate.now());
			  //child to parent
			 per.setLicenseDetails(license);
			 
			System.out.println(service.registerPersonWithDrivingLicense(per));
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*		System.out.println("==========parent===to child================");
				service.fetchAllPersonDetails().forEach(per->{
					System.out.println("parent:: "+per);
					DrivingLicense license=per.getLicenseDetails();
					System.out.println("child::"+license);
				});
		*/
		
		  //child to parent 
		try { 
			 Person per=new Person(new Random().nextInt(1000),"suresh1","vizag1");
			 DrivingLicense license=new DrivingLicense(new Random().nextLong(),"4-wheeler",LocalDate.now());
			  // parent to child 
		       license.setPersonDetails(per);
			 
			System.out.println(service.registerLicenseWithPerson(license));
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}

		System.out.println("==========child to parent================");
		service.fetchAllLicenseDetails().forEach(lic->{
			System.out.println("child:: "+lic);
			Person  per=lic.getPersonDetails();
			System.out.println("parent:: "+per);
		});
		
		
	}

}
