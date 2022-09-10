package com.nt.reciever;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.nt.model.Player;

@Component
public class PTPMessageReciever {
	
	@JmsListener(destination = "queue2")
	public   void fetchMessage(Player player) {
		System.out.println("The recieved message ::"+player);
	}

}
