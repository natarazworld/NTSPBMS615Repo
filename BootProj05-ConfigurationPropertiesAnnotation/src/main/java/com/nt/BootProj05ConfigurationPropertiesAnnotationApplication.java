package com.nt; 

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.beans.CustomerInfo;
import com.nt.beans.Employee;

@SpringBootApplication
public class BootProj05ConfigurationPropertiesAnnotationApplication {

	public static void main(String[] args) {
		//get IOC Container
		ApplicationContext ctx=	SpringApplication.run(BootProj05ConfigurationPropertiesAnnotationApplication.class, args);
		//Get Spring class object
		CustomerInfo info=ctx.getBean("custInfo",CustomerInfo.class);
		//invoke method b.method
		System.out.println("CustomerInfo object data::"+info);
		
     System.out.println("===========================");		
		//Get Spring class object
		Employee emp =ctx.getBean("emp",Employee.class);
		//invoke method b.method
		System.out.println("Employee object data::"+emp);

		
		
		
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
