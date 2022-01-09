package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.Movie;
import com.nt.view.View;


public interface IMovieRepo extends JpaRepository<Movie, Integer> {
	
	public <T extends View> Iterable<T>  findByMnameIn(List<String> movies,
			                                                                                                     Class<T> clazz);
	
	

}
