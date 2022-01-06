package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.Movie;

public interface IMovieRepo extends JpaRepository<Movie, Integer> {
	
	//select mid,mname,year,ratings  from Movie where mname=?
	public List<Movie>  findByMnameEquals(String name);
	//select mid,mname,year,ratings  from Movie where mname=?
	public List<Movie>  findByMnameIs(String name);
	//select mid,mname,year,ratings  from Movie where mname=?
	public Iterable<Movie>  findBymname (String name);
	
	//select mid,mname,year,ratings  from Movie where mname like 'R%'
	public Iterable<Movie>  findByMnameStartingWith(String initChars);
	
	//select mid,mname,year,ratings  from Movie where mname like '%n'
	public Iterable<Movie>  findByMnameEndingWith(String lastChars);
	
	//select mid,mname,year,ratings  from Movie where mname like '%dhe%'
	public Iterable<Movie>  findByMnameContaining(String chars);
	
	//select mid,mname,year,ratings  from Movie where mname like '%dhe%'
		public Iterable<Movie>  findByMnameEqualsIgnoreCase(String name);
		
		//select mid,mname,year,ratings  from Movie where mname like '%dhe%'
		public Iterable<Movie>  findByMnameContainingIgnoreCase(String chars);
		
		//select mid,mname,year,ratings  from Movie where mname like 'R%'  // movies starting with R
		//select mid,mname,year,ratings  from Movie where mname like '___'  // 3 letter movies
		//select mid,mname,year,ratings  from Movie where mname like '%R%'  //Containing letter R
		//select mid,mname,year,ratings  from Movie where mname like '%R'  //ending  letter R
			public Iterable<Movie>  findByMnameLike(String chars);  // pass wild chars while calling method
			
  /* finder methods  with mutliple propeties based  conditions   */
			//select mid,mname,year,ratings from Movie where mid>? and ratings<? 
			public  Iterable<Movie> findByMidGreaterThanAndRatingLessThan(int startMid, float endRatings);
			
			//select mid,mname,year,ratings from Movie where Mname like 'R%' or  (ratings between 3.0 and 5.0)
			public Iterable<Movie> findByMnameStartingWithOrRatingBetween(String mnameChars,
					                                                                                                                             float startRating,
					                                                                                                                             float endRatings);
			
			           //select mid,mname,year,ratings from Movie where year in (? , ?) or (upper(mname) like upper(?) escape ?) and (ratings between ? and ?)
			public Iterable<Movie> findByYearInOrMnameContainingIgnoreCaseAndRatingBetween(List<String> years,
					                                                                                                                                                                     String chars,
					                                                                                                                                                              float startRatings,
					                                                                                                                                                              float endRatings);
			//select mid,mname,year,ratings from Movie where (mname not like ? escape ?) and (year in (? , ?)) order by mname asc
			public Iterable<Movie> findByMnameNotLikeAndYearInOrderByMnameAsc(String letters,
					                                                                                                                                                          List<String> years);
					                                                                                                                                                          
			
			
			
			
			
				
		
	
	
	
	

}
