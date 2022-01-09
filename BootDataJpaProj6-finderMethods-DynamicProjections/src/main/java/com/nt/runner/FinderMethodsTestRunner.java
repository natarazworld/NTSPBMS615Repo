package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.model.Movie;
import com.nt.repository.IMovieRepo;

@Component
public class FinderMethodsTestRunner implements CommandLineRunner {
	@Autowired
	private  IMovieRepo  repo;  // InMememory proxy class obj of our Repository(I) will be injected

	@Override
	public void run(String... args) throws Exception {
		/* Iterable<ResultView1> list=repo.findByMnameIn(List.of("RRR","Don"),
				                                                                                                     ResultView1.class);
		 list.forEach(v1->{System.out.println(v1.getMid()+"  "+v1.getMname());});
		 System.out.println("--------------------------");
		 
		  repo.findByMnameIn(List.of("RRR","Don"),
				                                          ResultView2.class).forEach(v2->{System.out.println(v2.getMid()+"  "+v2.getMname()+" "+v2.getRating());});
		  
		  System.out.println("--------------------------");
		  repo.findByMnameIn(List.of("RRR","Don"),
		          ResultView3.class).forEach(v3->{System.out.println(v3.getMid()+"  "+v3.getMname()+" "+v3.getYear());});
		*/
		
		Movie movie=new Movie();
		movie.setMname("spiderman");
		movie.setRating(5.6f);
		movie.setYear("2022");
		System.out.println(repo.save(movie).getMid()+"--- object is saved");
		
	}

}
