package com.nt.test;

import java.time.LocalDateTime;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.beans.WishMessageGenerator;
import com.nt.config.AppConfig;

public class DependencyManagementTest {

	public static void main(String[] args) {
		 //create IOC container
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		 //get taget class object
		//WishMessageGenerator generator=ctx.getBean("wmg",WishMessageGenerator.class); //invoke the
		WishMessageGenerator generator=ctx.getBean("wishMessageGenerator",WishMessageGenerator.class); //invoke the
		 String result=generator.generateWishMessage("raja");
		 System.out.println("output::"+result) ; //sysout + ctrl+space :: gives	 System.out.println(-)
		 System.out.println("=================");
		 LocalDateTime ldt=ctx.getBean("createLDT",LocalDateTime.class);
		 System.out.println(ldt);
		 
				
		//close IOC container
		ctx.close();


	}//main
}//class
