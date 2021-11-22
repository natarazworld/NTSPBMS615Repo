package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.dao.EmployeeDAO;

@SpringBootApplication
public class BootProj02AutoConfigurationApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootProj02AutoConfigurationApplication.class, args);
		//get DAO class obj ref 
		EmployeeDAO dao=ctx.getBean("empDAO",EmployeeDAO.class);
		//invoke the method
		try {
		System.out.println("emps  count ::"+dao.getEmpsCount());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
		
	}//main
}//class
