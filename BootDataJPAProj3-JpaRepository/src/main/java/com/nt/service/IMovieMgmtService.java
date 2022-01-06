//service Interface
package com.nt.service;

import java.util.List;

import com.nt.entity.Movie;


public interface IMovieMgmtService {
	
	public  String  removieMoviesByIds(List<Integer> ids);
	public   List<Movie>  searchMoviesByMovie(Movie movie, boolean asc, String ...props);
	public  Movie    searchMovieById(Integer id);
	

}
