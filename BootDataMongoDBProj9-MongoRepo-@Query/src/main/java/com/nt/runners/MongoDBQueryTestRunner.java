package com.nt.runners;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.ITouristMgmtService;

@Component
public class MongoDBQueryTestRunner implements CommandLineRunner {
	@Autowired
	private ITouristMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		
		//service.fetchTouristsByNativePlaceWithRegEx("^U").forEach(System.out::println);  //starts with U
		//service.fetchTouristsByNativePlaceWithRegEx("a$").forEach(System.out::println); // ends with a
		//service.fetchTouristsByNativePlaceWithRegEx("a").forEach(System.out::println); // contains  a
		System.out.println("===================================");
		//System.out.println("Tourists count ::"+service.fetchTouristsCountByAgeRange(40,50));
		System.out.println("=====================================");
		//service.fetchTouristsSortedByName().forEach(System.out::println);
		
		System.out.println("=====================================");
		//System.out.println("delete docs count is ::"+service.deleteTouristsWithNoContactNumber());
		
		System.out.println("====================");
		System.out.println("Does the Tourist exist without vaccination::"+service.IsThereTouristsWithOutVaccination());
		
		
	}

}// class
