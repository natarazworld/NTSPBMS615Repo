package com.nt;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.dao.EmployeeDAO;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class BootProj02AutoConfigurationApplication {
	
	
	@Bean
	public  DataSource    createDs() throws Exception{
		ComboPooledDataSource cds=new ComboPooledDataSource();
		cds.setDriverClass("oracle.jdbc.driver.OracleDriver");
		cds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		cds.setUser("system");
		cds.setPassword("manager");
		return cds;
	}

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
