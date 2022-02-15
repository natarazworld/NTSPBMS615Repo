package com.nt.runners;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.PersonInfo;
import com.nt.service.IPersonInfoMgmtService;

@Component
public class MongoDBPersonInfoRunner implements CommandLineRunner {
	@Autowired
	private IPersonInfoMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		try {
			Properties props=new Properties();
			props.put("aadhar", 543535435);
			props.put("voterId", 354355435);
			PersonInfo info=new PersonInfo(new Random().nextInt(10000),"raja","hyd",
					                                                             new String[] {"red","green","yellow"},
					                                                             List.of("srinu","ramesh"),
					                                                             Set.of(9999999L,8888888L),
					                                                             Map.of("sbi",454354354L,"icici",54353543L),
					                                                             props);
			
			System.out.println(service.registerPerson(info));
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}// main(-)
}// class
