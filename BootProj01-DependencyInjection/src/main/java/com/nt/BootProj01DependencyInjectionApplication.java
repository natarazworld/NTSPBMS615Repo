package com.nt;

import java.util.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.beans.WishMessageGenerator;

@SpringBootApplication
public class BootProj01DependencyInjectionApplication {
	
	public BootProj01DependencyInjectionApplication() {
		System.out.println("BootProj01DependencyInjectionApplication:: 0-param construtor");
	}
	
	@Bean(name="cal")
	 public   Calendar  createCalendar() {
		System.out.println("BootProj01DependencyInjectionApplication.createCalendar()");
		 return  Calendar.getInstance();  //return GregorianCalendar class(sub class of Calenar) obj 
	 }

	public static void main(String[] args) {
		System.out.println("main(-) method");
		//Bootstrap  /boot  spring boot App and get IOC container ref
		ApplicationContext ctx=SpringApplication.run(BootProj01DependencyInjectionApplication.class, args);
		System.out.println("IOC container  class name ::"+ctx.getClass());
		System.out.println("==========================================");
		//get target class object
		WishMessageGenerator generator=ctx.getBean("wmg",WishMessageGenerator.class);
		System.out.println("=============================");
		//invoke b.method
		String result=generator.generateWishMessage("raja");
		System.out.println("Wish Message is ::"+result);
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
		System.out.println("end of main(-)");
		
	}

}
