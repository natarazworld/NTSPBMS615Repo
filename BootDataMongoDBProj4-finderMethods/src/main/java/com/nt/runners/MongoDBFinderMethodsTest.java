package com.nt.runners;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.Tourist;
import com.nt.service.ITouristMgmtService;

@Component
public class MongoDBFinderMethodsTest implements CommandLineRunner {
	@Autowired
	private ITouristMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		
		//=====  call finder methods ===============
	//	service.fetchTouristsByNativePlaceAscOrder("USA").forEach(System.out::println);
		System.out.println("------------------------------");
		Tourist tourist=service.fetchTouristByContactNo(888888L);
		if(tourist==null)
			System.out.println("tourist not found");
		else
			System.out.println("tourist details :"+tourist);
	}// main(-)
}// class
