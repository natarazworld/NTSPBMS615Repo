package com.nt.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehicle")
//  A all spring beans are taken as final class ( StrategyDP Rule#3)   
public final class Vehicle { 
	@Autowired   // For Filed Level Dependency Injection
	@Qualifier("engineType")   // works becoz engineType collected from <alias> tag.
	//@Qualifier(@Value("${choose.engine}")    // Does not work becoz @Value can not placed inside another annotation
	private Engine engg;  //HAS- A Property  (compositon : StrategyDP Rule#1)
	       //HAS A property type is  Interface type   StrategyDP Rule#2)
	       // All Dependent classes are implementing common Interface StrategyDP Rule#2)
	
	public Vehicle() {
		System.out.println("Vehicle:: 0-param constructor");
	}
	
	//b,method usng the dependent
	public  void journery(String startPlace, String destPlace) {
		engg.start();
		System.out.println("Vechicle:: journey started at::"+startPlace);
		System.out.println("journey is  goining on........");
		engg.stop();
		System.out.println("Vechicle:: journey stopped at::"+destPlace);
	}
}
