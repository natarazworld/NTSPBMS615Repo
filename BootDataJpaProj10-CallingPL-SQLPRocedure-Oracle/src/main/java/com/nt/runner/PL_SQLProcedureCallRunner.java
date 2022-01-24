package com.nt.runner;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.model.Movie;

/*CREATE OR REPLACE PROCEDURE P_GET_MOVIES_BY_YEAR_RANGE 
(
  STARTYEAR IN VARCHAR2 
, ENDYEAR IN VARCHAR2 
, DETAILS OUT SYS_REFCURSOR 
) AS 
BEGIN
  
  open details for
     SELECT MID,MNAME,RATING,YEAR FROM SP_DATA_MOVIE WHERE YEAR>=STARTYEAR AND YEAR<=ENDYEAR;
  
END P_GET_MOVIES_BY_YEAR_RANGE;


*/
@Component
public class PL_SQLProcedureCallRunner implements CommandLineRunner {
	@Autowired
	 private EntityManager  manager;

	@Override
	public void run(String... args) throws Exception {
		// crreate StoredProcedureQuery object representing  the given PL/SQL procedure  
		StoredProcedureQuery query=manager.createStoredProcedureQuery("P_GET_MOVIES_BY_YEAR_RANGE",Movie.class);
		//register  parameters of PL/SQL procedure with  java types
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, Movie.class, ParameterMode.REF_CURSOR);
		//set values  to IN params
		query.setParameter(1, "1900");
		query.setParameter(2, "2021");
		
		//call  PL/SQL Procedure and get thr results
		List<Movie> list=query.getResultList();
		list.forEach(System.out::println);
	}//run(-)

}//class
