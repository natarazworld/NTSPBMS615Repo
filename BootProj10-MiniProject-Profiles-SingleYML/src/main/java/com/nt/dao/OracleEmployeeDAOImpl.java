package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("oraEmpDAO")
@Profile({"uat","prod"})
public class OracleEmployeeDAOImpl implements IEmployeeDAO {
	private static final String GET_EMPS_BY_DESGS="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?) ORDER BY JOB";
	@Autowired
	private DataSource ds;
	
	public OracleEmployeeDAOImpl() {
		System.out.println("OracleEmployeeDAOImpl:0-param constructor");
	}
	

	@Override
	public List<Employee> getEmpsByDesgs(String desg1, String desg2, String desg3) throws Exception {
		System.out.println("OracleEmployeeDAOImpl.getEmpsByDesgs() ::"+ds.getClass());
		  List<Employee> listEmps=null;
	     //get pooled jdbc con object
		try(Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(GET_EMPS_BY_DESGS)){  // try with resource
			   //set qury param values
			   ps.setString(1, desg1);
			   ps.setString(2, desg2);
			   ps.setString(3, desg3);
			   
			   //execute the query
			   try(ResultSet rs=ps.executeQuery()){
				   // copy  ResultSet object records to List collection as Employee class objects
				   listEmps=new ArrayList();
				      while(rs.next()) {
				    	  Employee emp=new Employee();
				    	  emp.setEmpno(rs.getInt(1));
				    	  emp.setEname(rs.getString(2));
				    	  emp.setJob(rs.getString(3));
				    	  emp.setSal(rs.getFloat(4));
				    	  listEmps.add(emp);
				      }//while
			   }//try2
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
			throw se; // exception rethrowing
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e; //exception rethrowing
		}
	
	return listEmps;
	}//method

}//class
