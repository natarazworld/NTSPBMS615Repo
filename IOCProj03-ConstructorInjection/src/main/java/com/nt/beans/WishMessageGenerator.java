//WishMessageGenerator.java
package com.nt.beans;

import java.util.Date;

public class WishMessageGenerator {
	//HAS-A property (supporting composition)
	private  Date  date;
	
	
	// for constructor Injection
	private WishMessageGenerator(Date dat) {
		System.out.println("WishMessageGenerator:1-param constructor");
		this.date = dat;
	}
	
	
	public void setDate1(Date date) {
		System.out.println("WishMessageGenerator.setDate(-)");
		this.date = date;
	}




	//B.method
	public  String generateMessage(String user) {
		System.out.println("WishMessageGenerator.generateMessage() :::"+date);
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
