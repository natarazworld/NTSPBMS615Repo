package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Movie;
import com.nt.service.IMovieMgmtService;

@Component
public class CrudRepTestRunner implements CommandLineRunner {
	@Autowired
	private IMovieMgmtService service;

	@Override
	public void run(String... args) throws Exception {
	     
		/*//invoke sevice method
		  Movie movie=new Movie();
		  movie.setMname("RRR");
		  movie.setRating(4.5f);
		  movie.setYear("2022");
		  try {
			  System.out.println(service.registerMovie(movie));
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }*/
		  
		/* System.out.println("------------------------------------------");
		 try {
		  System.out.println("recors count::"+service.fetchMoviesCount());
		 }
		 catch(Exception e) {
		  e.printStackTrace();
		 }
		 
		 System.out.println("------------------------------------------");
		 try {
		  System.out.println("Is 2 mid  movie availble ?"+service.checkMovieById(1));
		 }
		 catch(Exception e) {
		  e.printStackTrace();
		 }*/
		
		/* System.out.println("--------for  findAll()--method---------------");
		 try {
		    Iterable<Movie> list=service.fetchAllMovies();
		    for(Movie movie:list) { //enahaced for loop
		    	System.out.println(movie);
		    }
		    System.out.println("..........");
		    list.forEach(movie->{   //forEach() method
		    	System.out.println(movie);
		    });
		    System.out.println("..........");
		    list.forEach(movie-> System.out.println(movie));  //forEach() method
		    System.out.println("..........");
		    list.forEach(System.out::println);  // forEach method +  static method reference
		    System.out.println("..........");
		    Arrays.asList(list).stream().forEach(System.out::println); //forEach  method +streaming api+ static method reference
		    
		 }
		 catch(Exception e) {
		  e.printStackTrace();
		 }
		  */
		
		/*System.out.println("--------for  findAllById(-)--method---------------");
		try {
			List<Integer> IdsList=new ArrayList();
			IdsList.add(189); IdsList.add(1);
			System.out.println("movices are ::"+service.fetchAllMoviesByIds(IdsList));
			System.out.println("--------------------------------------");
		    System.out.println("movies are ::"+service.fetchAllMoviesByIds(List.of(189,1)));   //java 9
		    System.out.println("---------------------------------");
		    System.out.println("movies are ::"+service.fetchAllMoviesByIds(Arrays.asList(189,1,2)));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		*/
		
		/*System.out.println("--------for  findById(-)--method---------------");
		try {
			System.out.println("18 move is::"+service.fetchMovieById(18));
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}*/
		
		/*System.out.println("--------for  findById(-)--method---------------");
		try {
			System.out.println("189 move is::"+service.fetchMovieById(189));
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}*/
		
		/*System.out.println("--------for  findById(-)--method---------------");
		try {
			Optional<?> opt=service.gatherMovieById(18);
			if(!opt.isEmpty())
				System.out.println("189 movie:"+opt.get());
			else
				System.out.println("record not found");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}*/
		
		
		/*System.out.println("--------for saveAll(-)--method---------------");
		try {
		     String result=service.groupMovieRegistration(List.of(new Movie("RRR","2022",5.6f),
		    		                                                                                                   new Movie("83","2021",4.6f),
		    		                                                                                                   new Movie("jersy","2022",4.7f)
		    		                                                                                                  ));  //java9 feature
		System.out.println(result);		     
		     
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		/*	
			System.out.println("--------for save(-) for update object operation--method---------------");
			try {
				String result=service.updateMovieDetails(189,"1999", 4.0f);
				System.out.println(result);
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		
		/*System.out.println("--------for save(-) for update object operation--method---------------");
		try {
			Movie movie=new Movie("RRR2","2021", 5.0f);
			movie.setMid(119);
			String result=service.updateMovie(movie);
			System.out.println(result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		
		/*	System.out.println("--------for deleteById(-) for delete object operation--method---------------");
			try {
				System.out.println(service.removeMovieById(189));
				
			}//try
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		
		/*System.out.println("--------for delete(-) for delete object operation--method---------------");
		try {
                 Movie movie=new Movie();
                 movie.setMid(4);
			System.out.println(service.removeMovie(movie));
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		
		/*System.out.println("--------for deleteAll(-) for deleting all objects operation----------------");
		try {
			System.out.println(service.removeAllMovies());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		*/
		
		
		System.out.println("--------for deleteAllById(-) for deleting all objects operation----------------");
		try {
			System.out.println(service.removeAllMoviesById(List.of(11,12)));
		}
		catch(NullPointerException  npe) {
			System.out.println("Id(s) must not be null");
			npe.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
			
		
		
			
		
		
		
	}

}
