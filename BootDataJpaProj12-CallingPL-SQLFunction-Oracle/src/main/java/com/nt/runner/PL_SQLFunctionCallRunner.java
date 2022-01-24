package com.nt.runner;


import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import oracle.jdbc.OracleTypes;

/*create or replace FUNCTION FX_GET_MOVIES_BY_RATINGS 
(
  START_RATING IN NUMBER 
, END_RATING IN NUMBER 
, CNT OUT NUMBER 
) RETURN SYS_REFCURSOR AS 
   details SYS_REFCURSOR;
BEGIN
   SELECT COUNT(*) INTO CNT FROM SP_DATA_MOVIE;
   
   OPEN DETAILS FOR
     SELECT MNAME,RATING,YEAR  FROM SP_DATA_MOVIE WHERE RATING>=START_RATING AND RATING<=END_RATING;

  RETURN DETAILS;
  
END FX_GET_MOVIES_BY_RATINGS;
*/

@Component
public class PL_SQLFunctionCallRunner implements CommandLineRunner {
	@Autowired
	 private EntityManager  manager;

	@Override
	public void run(String... args) throws Exception {
		  //unwrap  SEsssion object from  EntityManager object
		Session ses=manager.unwrap(Session.class);
		//Work with  ReturnigWork<T> callback based Callback method
	Object results[]= ses.doReturningWork(con->{
			      //write  CallbackSTatement based logic to call PL/SQL function
		     CallableStatement cs=con.prepareCall("{?=call FX_GET_MOVIES_BY_RATINGS(?,?,?)}");
		        //register return(1) , out params(4) with jdbc types
		       cs.registerOutParameter(1,OracleTypes.CURSOR);
		       cs.registerOutParameter(4, Types.INTEGER);
		     // set values to IN parameters
		        cs.setFloat(2,4.0f);
		        cs.setFloat(3,5.5f);
		        //call  Pl/SQL function
		        cs.execute();
		        //gather results from output Parameters
		        ResultSet rs=(ResultSet)cs.getObject(1);  // return value;
		          List<Object[]> list=new ArrayList();
		          while(rs.next()) {
		        	  Object record[]=new Object[3];
		        	  record[0]=rs.getString(1);
		        	  record[1]=rs.getString(2);
		        	  record[2]=rs.getString(3);
		        	  list.add(record);
		          }//while
		          Object data[]=new Object[2];
		          data[0]=list;
		          data[1]=cs.getInt(4);  //out param cnt value
		        return data;
		   });
	
		//process the ressult[]
	    System.out.println("movies in ratings range are::");
	      List<Object[]> ratingsList=(List<Object[]>) results[0];
	      ratingsList.forEach(md->{
	    	    for(Object val:md)
	    	    	  System.out.print(val+" ");
	    	    System.out.println();
	      });
	      
	      //get count of records
	      int count=(int) results[1];
	      System.out.println("records count::"+count);
	
	}//run(-)

}//class
