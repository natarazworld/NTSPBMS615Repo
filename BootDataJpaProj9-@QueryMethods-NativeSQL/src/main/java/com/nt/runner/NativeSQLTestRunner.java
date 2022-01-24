package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IMovieRepo;

@Component
public class NativeSQLTestRunner implements CommandLineRunner {
	@Autowired
	private IMovieRepo  repo;

	@Override
	public void run(String... args) throws Exception {
//		 int result=repo.registerMovie("raja", 4.5f, "2021");
//		 System.out.println(result==0?"movie not registered":"movie registered");
		System.out.println("---------------------");
		  System.out.println("date and time is ::"+ repo.fetchSysDate());
		  System.out.println("------------------");
		 int result=repo.createTempTable();
		 System.out.println(result<0?"Table is not created":"table is created");
		  

	}//run(-)

}//class
