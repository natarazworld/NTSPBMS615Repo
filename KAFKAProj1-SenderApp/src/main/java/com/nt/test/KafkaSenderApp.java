package com.nt.test;

import java.util.Properties;
import java.util.Scanner;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;


public class KafkaSenderApp {

	public static void main(String[] args) {
	    //prepare Kafka Properties using java.util.Properties class obj
		Properties props=new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
		//create KafkaProducer object
		KafkaProducer<String, String> producer=new KafkaProducer<String, String>(props);
		
		ProducerRecord<String,String> record=null;
		String msg=null;
		do {
			 Scanner  sc=new Scanner(System.in);
			 System.out.println("Enter message::");
             msg=sc.nextLine();
		//  Create ProducerRecord object having topic name and Message
		 record=new ProducerRecord<String, String>("nit-tp2", msg);
		 // send the message
		  producer.send(record);
		  //flush the message
		  producer.flush();
		}
		while(!msg.equalsIgnoreCase("stop"));
		
		  //close the link with  Bootstrap server..
		  producer.close();
		  
		  
		 
		
		

	}

}
