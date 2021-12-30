// service Impl class
package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Movie;
import com.nt.repository.IMovieRepo;

@Service("movieService")
public class MovieMgmtServiceImpl implements IMovieMgmtService {
	@Autowired    //injects the dynamically generated proxy class object 
	private IMovieRepo  movieRepo;  //HAS-A proeprty
	

	@Override
	public Iterable<Movie> displayMoviesByOrder(boolean asc, String... properites) {
		   Sort sort=Sort.by(asc?Direction.ASC:Direction.DESC, properites);
		return movieRepo.findAll(sort);
	}
		
	
	@Override
	public Page<Movie> generateReport(int pageNo, int pageSize, boolean asc, String... props) {
		//create Pageable object
	     Pageable pageable=PageRequest.of(pageNo, pageSize,Sort.by(asc?Direction.ASC:Direction.DESC, props));
	     // get requested page records
	     Page<Movie> page=movieRepo.findAll(pageable);
		return page;
	}
	
	@Override
	public void generateMoviesReport(int pageSize) {
		 //get count of records
		 long recordsCount=movieRepo.count();
		 //decide no.of pages (pagesCount)
		 long pagesCount=0;
	 if(pageSize>=1) {
		 pagesCount=recordsCount/pageSize;
		 // get exact pagesCount
		 pagesCount=recordsCount%pageSize==0?pagesCount:++pagesCount;
	 }
	 else {
		 throw new IllegalArgumentException("PageSize can not be <=Zero");
	 }
		 
		 for(int pageNo=0;pageNo<pagesCount;++pageNo) {
			 //prepare pageable object
			 Pageable pageable=PageRequest.of(pageNo, pageSize);
			 Page<Movie> page=movieRepo.findAll(pageable);
			 	 System.out.println("---- page no::"+(pageNo+1)+" pageSize: "+pageSize+" pageRecords count:: "+page.getNumberOfElements()+"------");
			 	 List<Movie> list=page.getContent();
			 	 list.forEach(movie->{
			 		 System.out.println(movie);
			 	 });
		 }//for
		 
	}//method
}
