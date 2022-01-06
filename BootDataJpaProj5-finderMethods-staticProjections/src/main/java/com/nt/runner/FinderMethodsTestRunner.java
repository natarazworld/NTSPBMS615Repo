package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IMovieRepo;
import com.nt.view.ResultView;

@Component
public class FinderMethodsTestRunner implements CommandLineRunner {
	@Autowired
	private  IMovieRepo  repo;  // InMememory proxy class obj of our Repository(I) will be injected

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Reposity impl class name::"+repo.getClass());
		Iterable<ResultView> it=repo.findByMidGreaterThanEqualAndMidLessThanEqual(100,500);
		it.forEach(view->{
			 System.out.println("dynamic model class name"+view.getClass());
			  System.out.println(view.getMid()+"   "+view.getMname());
		});
		
	}

}
