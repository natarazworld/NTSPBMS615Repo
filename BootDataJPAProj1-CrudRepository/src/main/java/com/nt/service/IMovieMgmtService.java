//service Interface
package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.Movie;


public interface IMovieMgmtService {
    public  String registerMovie(Movie movie);
    public  long  fetchMoviesCount();
    public   boolean  checkMovieById(Integer mid);
    public   Iterable<Movie>  fetchAllMovies();
    public  Iterable<Movie>  fetchAllMoviesByIds(List<Integer> mids);
    public   Movie  fetchMovieById(Integer mid);
    public   Optional<Movie>  gatherMovieById(Integer mid);
    public   String  groupMovieRegistration(List<Movie> moviesList);
    public   String   updateMovieDetails(Integer mid, String year, Float newRating );
    public  String updateMovie(Movie movie);
    public  String  removeMovieById(Integer mid);
    public  String  removeMovie(Movie movie);
    public  String   removeAllMovies();
    public  String   removeAllMoviesById(List<Integer> ids);
    
    
}
