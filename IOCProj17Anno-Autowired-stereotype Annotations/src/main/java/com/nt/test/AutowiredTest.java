package com.nt.test;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.WishMessageGenerator;

public class AutowiredTest {

	public static void main(String[] args) {
		//create IOC container
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean spring bean class obj
		WishMessageGenerator generator=ctx.getBean("wishMessageGenerator",WishMessageGenerator.class);
		
		
		//invoke the b.method
		String result=generator.generateMessage("raja");
		System.out.println("Wish Message is ::"+result); 
				
		
		//close the IOC container
		ctx.close();

	}//main
}//class
