package com.nt.consumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class KafkaConsumerApp {

	public static void main(String[] args) {
		  //prepare Kafka Properties using java.util.Properties class obj
				Properties props=new Properties();
				props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
				props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
				props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
				props.put(ConsumerConfig.GROUP_ID_CONFIG,"grp2_cons");
		 // Create KafkaConsumer  object
				 KafkaConsumer<String,String> consumer=new KafkaConsumer<String,String>(props);
			//  Subscribe to MessageBroker and Topic Section  (This create MessageBroker dynamically)
				    consumer.subscribe(Arrays.asList("nit-tp2"));
				   
				  
				    while(true) {
				    	  //Do polling on MessageBroker  to check and consume the messages
				    	ConsumerRecords<String, String>  records=consumer.poll(Duration.ofMillis(1000));
				    	 //display the message
				    	for(ConsumerRecord record:records) {
				    		 System.out.println(record.value());
				    	}
				    	
				    }//while
				   
				    

	}

}
