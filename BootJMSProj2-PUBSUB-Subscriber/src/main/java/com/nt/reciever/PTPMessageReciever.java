package com.nt.reciever;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class PTPMessageReciever {
	
	@JmsListener(destination = "topic1")
	public   void fetchMessage(String text) {
		System.out.println("The recieved message ::"+text);
	}

}
