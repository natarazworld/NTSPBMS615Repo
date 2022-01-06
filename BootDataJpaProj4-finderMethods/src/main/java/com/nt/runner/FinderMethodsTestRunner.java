package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IMovieRepo;

@Component
public class FinderMethodsTestRunner implements CommandLineRunner {
	@Autowired
	private  IMovieRepo  repo;  // InMememory proxy class obj of our Repository(I) will be injected

	@Override
	public void run(String... args) throws Exception {
		/* //=====finder methods ============
		repo.findByMnameEquals("Anthim").forEach(System.out::println);
		System.out.println("----------------------------");
		repo.findByMnameIs("Don").forEach(System.out::println);
		System.out.println("----------------------------");
		repo.findBymname("RRR").forEach(System.out::println);
		System.out.println("----------------------------");
		repo.findByMnameStartingWith("Ra").forEach(System.out::println);
		System.out.println("----------------------------");
		repo.findByMnameEndingWith("n").forEach(System.out::println);
		
		System.out.println("----------------------------");
		repo.findByMnameContaining("m").forEach(System.out::println);
		
		System.out.println("----------------------------");
		repo.findByMnameEqualsIgnoreCase("rrR").forEach(System.out::println);
		
		
		System.out.println("----------------------------");
		repo.findByMnameContainingIgnoreCase("r").forEach(System.out::println);
		
		
		System.out.println("----------------------------");
		//repo.findByMnameLike("R%").forEach(System.out::println); //or
		//repo.findByMnameLike("___").forEach(System.out::println); //or
		//repo.findByMnameLike("%R").forEach(System.out::println);//or
		repo.findByMnameLike("%R%").forEach(System.out::println); //or
		*/		
		System.out.println("========finder methods with multiple properties based conditions=========");
	    repo.findByMidGreaterThanAndRatingLessThan(300,5.0f).forEach(System.out::println);
		System.out.println("---------------------");
		repo.findByMnameStartingWithOrRatingBetween("R", 3.0f, 4.5f).forEach(System.out::println);
		System.out.println("--------------------");
		repo.findByYearInOrMnameContainingIgnoreCaseAndRatingBetween(List.of("2021","2022"),
				                                                                                                                                                  "r", 
				                                                                                                                                         3.0f, 5.0f).forEach(System.out::println);
		System.out.println("--------------------");
		repo.findByMnameNotLikeAndYearInOrderByMnameAsc("R%", List.of("2021","2022")).forEach(System.out::println);

	}

}
