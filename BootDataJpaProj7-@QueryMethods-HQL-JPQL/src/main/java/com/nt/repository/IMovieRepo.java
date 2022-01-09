package com.nt.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.model.Movie;


public interface IMovieRepo extends JpaRepository<Movie, Integer> {

	 //@Query("from Movie where mid>=?1 and mid<=?2")
	//@Query("from Movie as m where m.mid>=?1 and m.mid<=?2")
	/*@Query("from Movie  where mid>=:min and mid<=:max")
	 public List<Movie>  searchMoviesByIdRange(@Param("min") int start,@Param("max")  int end);*/
	
	@Query("from Movie  where mid>=:min and mid<=:max")
	 public List<Movie>  searchMoviesByIdRange( int min, int max);

}
