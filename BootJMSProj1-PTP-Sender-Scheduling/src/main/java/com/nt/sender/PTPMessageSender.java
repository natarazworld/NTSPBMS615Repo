// PTPMessageSenderRunner.java
package com.nt.sender;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PTPMessageSender {
	@Autowired
	private JmsTemplate  template;
	
	@Scheduled(cron = "*/10 * * * * *")
	public   void  sendMessage() {
		template.send("queue1",ses-> ses.createTextMessage("from Sender ::"+new Date()));
		
	}

	
}
