//WishMessageGenerator.java
package com.nt.beans;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component("wmg")
//@Scope("prototype")
@Lazy(true)
public class WishMessageGenerator {
	//HAS-A property (supporting composition)
	@Autowired
	private  Date  date;
	
   public WishMessageGenerator() {
	System.out.println("WishMessageGenerator:: 0-param cosntructor");
}
	
	//B.method
	public  String generateMessage(String user) {
		System.out.println("WishMessageGenerator.generateMessage():: date="+date);
		//get current hour of the day
		int hour=date.getHours(); // 24 hours format (0 to 23)
		//generate wish messsage
		 if(hour<12)
			 return "Good Morning::"+user;
		 else if(hour<16)
			 return "Good AfterNoon::"+user;
		 else if(hour<20)
			 return "Good Evening::"+user;
		 else
			 return "Good Night::"+user;
	}//method
}//class
