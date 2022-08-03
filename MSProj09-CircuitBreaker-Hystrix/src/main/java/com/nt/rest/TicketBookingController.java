//TicketBookingController.java
package com.nt.rest;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/ticket")
public class TicketBookingController {

	@GetMapping("/booking")
	@HystrixCommand(fallbackMethod = "dummyBookTickets")
	public  String   bookTickets() {
		System.out.println("TicketBookingController.bookTickets()");
		if(new Random().nextInt(10)<3) 
			throw new IllegalArgumentException("problem in ticket bookig");
			
			return "Tickets booked sucessfully";
		}//method
	
	
	public  String dummyBookTickets() {   // this method should not have params
		System.out.println("TicketBookingController.dummyBookTickets()");
		return " Sorry for inconvience .... some problem in ticket booking";
	}
	
}//class
	
