package com.nt.runner;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Movie;
import com.nt.repository.IMovieRepo;
import com.nt.service.IMovieMgmtService;

@Component
public class CrudRepTestRunner implements CommandLineRunner {
	@Autowired
	private IMovieMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		
		
		/*System.out.println("----------findAll(Sort sort)-------");
		try {
		Iterable<Movie> it=service.displayMoviesByOrder(false,"year","mname");
		it.forEach(System.out::println);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*	System.out.println("----------findAll(Pageable pageable)-------");
			try {
			 Page<Movie> page=service.generateReport(2, 3, true, "mname");
			 System.out.println("page number::"+page.getNumber());
			 System.out.println("pages count::"+page.getTotalPages());
			 System.out.println(" is it first page::"+page.isFirst());
			 System.out.println(" is it last page::"+page.isLast());
			 System.out.println("page Size::"+page.getSize());
			 System.out.println("page Elements count::"+page.getNumberOfElements());
			 if(!page.isEmpty()) {
			   
			    List<Movie> list=page.getContent();
			    list.forEach(System.out::println);
			 }
			 else
				 System.out.println("no page found");
			}//try
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		System.out.println("----------findAll(Pageable pageable)-------");
		try {
		   service.generateMoviesReport(0);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//main
}//class
