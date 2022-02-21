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
		
		//service.fetchAllTouristByNativePlace("nepal").forEach(System.out::println);
		System.out.println("----------------------------------------------------");
		//service.fetchAllTouristByNativePlaceAndAge("USA", 20).forEach(System.out::println);
		System.out.println("----------------------------------------------------");
		//service.fetchAllTouristByAgeRange(20, 48).forEach(System.out::println);
		System.out.println("----------------------------------------------------");
		//service.fetchAllTouristsByNativePlaces("nepal","USA").forEach(System.out::println);
		System.out.println("----------------------------------------------------");
		/*service.fetchTouristDataByNativePlace("USA").forEach(row->{
			 System.out.println(Arrays.toString(row));  //(or)
			/*for(Object val:row) {
				System.out.print(val);
			}
			System.out.println();  (or) */
			
			/*for(int i=0;i<row.length;++i) {
				System.out.print(row[i]);
			}
			System.out.println();*/
			
		//}); */
		
		service.fetchTouristDataByNativePlaces("nepal","USA","canada").forEach(row->{
			System.out.println(Arrays.toString(row));
		});
		
	}

}// class
