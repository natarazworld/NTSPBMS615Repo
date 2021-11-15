//WishMessageGenerator.java (target class)
package com.nt.beans;

import java.time.LocalDateTime;  //ctrl+shift+o  for importing pkgs

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("wmg")  //spring bean cfg having "wmg" as the bean id
@Component
public class WishMessageGenerator {
	 //HAS -A property
	@Autowired   // Annoation marking the HAS-A property for Dependency Injection/Management
	private LocalDateTime  ldt; //by default holds null ... after Injection/wiring this null will be replaced
	                                                     //with  Dependent LocalDateTime class object.
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator:: 0-param construtor");
	}
	
	// b.method
	public  String  generateWishMessage(String user) {
		System.out.println(ldt);
		//get current hour
		int hour=ldt.getHour();  //24 hrs format
		//write b.logic
		if(hour<12)
			return "Good Morning::"+user;
		else if(hour<16)
			return "Good Afternoon::"+user;
		else if(hour<20)
			return "Good Evening::"+user;
		else
			return "Good Night::"+user;
			
		
		
		
	}
	
	
	

}
