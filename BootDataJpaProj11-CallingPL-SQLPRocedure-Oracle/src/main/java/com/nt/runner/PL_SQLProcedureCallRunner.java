package com.nt.runner;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*create or replace PROCEDURE PRO_AUTHENTICATION 
(
  USER IN VARCHAR2 
, PASS IN VARCHAR2 
, RESULT OUT VARCHAR2 
) AS 
   CNT NUMBER;
BEGIN

   SELECT COUNT(*) INTO CNT FROM USERSLIST WHERE  UNAME=USER AND PWD=PASS;
   
   IF(CNT<>0) THEN
      RESULT:='VALID CREDENTIALS';
   ELSE
      RESULT:='INVALID CREDENTIALS';
    END IF ; 
END PRO_AUTHENTICATION;
*/

@Component
public class PL_SQLProcedureCallRunner implements CommandLineRunner {
	@Autowired
	 private EntityManager  manager;

	@Override
	public void run(String... args) throws Exception {
		//Create Stored ProcedureQuery object
		 StoredProcedureQuery query=manager.createStoredProcedureQuery("PRO_AUTHENTICATION");
		 //register parameters with  java  types
		 query.registerStoredProcedureParameter(1, String.class,ParameterMode.IN);
		 query.registerStoredProcedureParameter(2, String .class, ParameterMode.IN);
		 query.registerStoredProcedureParameter(3, String .class, ParameterMode.OUT);
		 //set values to IN params
		 query.setParameter(1, "raja");
		 query.setParameter(2,"rani1");
		 //call PL/SQL procedure
		  String result=(String)query.getOutputParameterValue(3);
		  System.out.println("Authentication result::"+result);
	}//run(-)

}//class
