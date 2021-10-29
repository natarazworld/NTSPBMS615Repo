package com.nt.test;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.WishMessageGenerator;

public class AutowiredTest {

	public static void main(String[] args) {
		//create IOC container
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
				//get Bean spring bean class obj
				WishMessageGenerator generator=ctx.getBean("com.nt.beans.WishMessageGenerator#0",WishMessageGenerator.class);
				
				WishMessageGenerator generator1=ctx.getBean("com.nt.beans.WishMessageGenerator#1",WishMessageGenerator.class);
				System.out.println(generator.hashCode()+"   "+generator1.hashCode());
				
				//invoke the b.method
				String result=generator.generateMessage("raja");
				System.out.println("Wish Message is ::"+result); 
				
				System.out.println("spring beans count"+ctx.getBeanDefinitionCount());
				System.out.println("bean ids ::"+Arrays.toString(ctx.getBeanDefinitionNames()));
		
		//close the IOC container
		ctx.close();

	}//main
}//class
