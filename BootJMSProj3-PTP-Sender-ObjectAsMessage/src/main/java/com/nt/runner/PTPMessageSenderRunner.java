// PTPMessageSenderRunner.java
package com.nt.runner;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.nt.model.Player;

@Component
public class PTPMessageSenderRunner  {
	@Autowired
	private JmsTemplate  template;

	@Scheduled(cron="*/10 * * * * *")
	  public   void sendMessage() {
		
		 Player player=new Player(1,"kohli",LocalDateTime.of(1988, 11,5,10,22),"cricket");
		// LAMDA based Anonymous inner class for MessageCreator(I)
		template.convertAndSend("queue2",player);
		System.out.println("From Sender ---- The Message is sent");
			 
		
	}

}
