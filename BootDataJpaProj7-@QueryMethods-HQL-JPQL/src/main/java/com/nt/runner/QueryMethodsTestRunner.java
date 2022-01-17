package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IMovieRepo;

//@Component
public class QueryMethodsTestRunner implements CommandLineRunner {
	@Autowired
	private  IMovieRepo  repo;  // InMememory proxy class obj of our Repository(I) will be injected

	@Override
	public void run(String... args) throws Exception {
		System.out.println("====Query methods execution ============");
		/*List<Movie> list=repo.searchMoviesByIdRange(200, 500);
		list.forEach(System.out::println);*/
		  repo.searchMoviesByMnames("RRR","Don","puspha").forEach(System.out::println);
		  System.out.println("------");
		  repo.searchMoviesByMnames1("RRR","Don","puspha").forEach(System.out::println);
		  System.out.println("==================");
		  repo.fetchMovieDetailsByRatingsAndYear(4.0f, "2020","2021","2022").forEach(row->{
			      for(Object val:row)
			    	  System.out.print(val+"  ");
			      
			      System.out.println();
		  });
		  
		  System.out.println("==================");
		  repo.fetchMoviesByYearRange("2020","2022").forEach(System.out::println);
			
		
		
		
	}

}
