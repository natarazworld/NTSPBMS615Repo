package com.nt.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.beans.Vehicle;
import com.nt.config.AppConfig;

public class StrategyDPTest {

	public static void main(String[] args) {
		// create IOC container
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("==============================================");
		//get Target class object
		Vehicle vehicle=ctx.getBean("vehicle",Vehicle.class);
		//invole method
		vehicle.journery("delhi", "london");
		//close container
		ctx.close();
	}

}
