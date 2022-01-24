package com.nt.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nt.model.Movie;

@Transactional
public interface IMovieRepo extends JpaRepository<Movie, Integer> {
	
	
	@Query(value="INSERT INTO SP_DATA_MOVIE VALUES(MID_SEQ.NEXTVAL,?,?,?)",nativeQuery = true)
	@Modifying
   public   int  registerMovie(String name,float rating, String year);	
	
	@Query(value="SELECT SYSDATE from DUAL",nativeQuery = true)
	public   String   fetchSysDate();
	
	@Query(value="create table temp116(col1 number(5))",nativeQuery = true)
	@Modifying
	public int  createTempTable();
		

}
