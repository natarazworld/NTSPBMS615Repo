package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.model.Movie;
import com.nt.repository.IMovieRepo;

@Component
public class QueryMethodsTestRunner implements CommandLineRunner {
	@Autowired
	private  IMovieRepo  repo;  // InMememory proxy class obj of our Repository(I) will be injected

	@Override
	public void run(String... args) throws Exception {
		System.out.println("====Query methods execution ============");
		List<Movie> list=repo.searchMoviesByIdRange(200, 500);
		list.forEach(System.out::println);
		
		
	}

}
