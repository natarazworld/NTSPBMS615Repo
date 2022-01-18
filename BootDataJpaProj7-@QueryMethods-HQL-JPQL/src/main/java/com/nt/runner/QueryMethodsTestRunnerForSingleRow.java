package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.model.Movie;
import com.nt.repository.IMovieRepo;

@Component
public class QueryMethodsTestRunnerForSingleRow implements CommandLineRunner {
	@Autowired
	private  IMovieRepo  repo;  // InMememory proxy class obj of our Repository(I) will be injected

	@Override
	public void run(String... args) throws Exception {
	   Movie movie=repo.fetchMovieDataByMname("Anthim1");
	   if(movie!=null)
	     System.out.println("RRR Movie details are::"+movie);
	   else
		   System.out.println("Movie not found");
	   
	   System.out.println("-----------------------------------------");
	   Object data=repo.fetchMoviePartialDataByMname("Anthim");
	   Object result[]=(Object[])data;
	   for(Object val:result) {
		   System.out.print(val+" ");
	   }
	   System.out.println();
	   
	   System.out.println("-----------------------------------------");
	   
	   String year=repo.fetchMovieSingleDataByMname("Anthim");
	   System.out.println("Anthin movie release year ::"+year);
	   
	   System.out.println("---------------------------");
	    System.out.println("highest rating for movie::"+repo.fetchMaxRatingMovie());
	    
	    System.out.println("-----------------------------");
	    Object results1[]=(Object[])repo.fetchAggregateDataOnMoives();
	    System.out.println(" Max rating  "+results1[0]);
	    System.out.println(" Min rating  "+results1[1]);
	    System.out.println(" Avg rating  "+results1[2]);
	    System.out.println(" count of movies  "+results1[3]);
	    System.out.println(" avg of years  "+results1[4]);
	    System.out.println(" sum of years  "+results1[5]);
	    
	    System.out.println("-----------------------------");
	    repo.fetchMaxRatingMovies().forEach(System.out::println);
		   
       
		
				
		
	}

}
