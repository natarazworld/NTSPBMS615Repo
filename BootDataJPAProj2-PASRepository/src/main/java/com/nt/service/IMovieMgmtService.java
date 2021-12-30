//service Interface
package com.nt.service;

import org.springframework.data.domain.Page;

import com.nt.entity.Movie;


public interface IMovieMgmtService {
	  // One method can have only one var arg param that to last param of the method
	  // Var args are internally arrays..
     public  Iterable<Movie>  displayMoviesByOrder(boolean asc,String ... properites);    
     public  Page<Movie>   generateReport(int pageNo,int pageSize,boolean asc,String ...props);
     public  void  generateMoviesReport(int pageSize);
}
