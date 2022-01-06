package com.nt.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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

		/*System.out.println("----------deleteAllByIdInBatch(-)-------");
		try {
		  //System.out.println(service.removieMoviesByIds(List.of(513,456)));
			List<Integer> ids=new ArrayList();
			ids.add(567);
			ids.add(null); 
			List<Integer> ids=Arrays.asList(13,null);
			System.out.println(service.removieMoviesByIds(ids));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*System.out.println("----------findAll(Example,Sort)-------");
		try {
			 Movie movie=new Movie();
			 //movie.setMid(100); movie.setMname("RRR");
			 movie.setRating(4.1f); movie.setYear("2022");
			 List<Movie> list=service.searchMoviesByMovie(movie, true, "mname");
			 list.forEach(System.out::println);
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		System.out.println("----------getById(Integer id)-------");
		try {
			 System.out.println("416 Movie Details are "+service.searchMovieById(419));
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}// main
}// class
