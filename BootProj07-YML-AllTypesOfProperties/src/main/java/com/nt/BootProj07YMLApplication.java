package com.nt; 

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.beans.PersonInfo;

@SpringBootApplication
public class BootProj07YMLApplication{

	public static void main(String[] args) {
		//get IOC Container
		ApplicationContext ctx=	SpringApplication.run(BootProj07YMLApplication.class, args);
		//Get Spring class object
		PersonInfo info=ctx.getBean("pInfo",PersonInfo.class);
		//invoke method b.method
		System.out.println("PersonInfo object data::"+info);
     System.out.println("===========================");		
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
