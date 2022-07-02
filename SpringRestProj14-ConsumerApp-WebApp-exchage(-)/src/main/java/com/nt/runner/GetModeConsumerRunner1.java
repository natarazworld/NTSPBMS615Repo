//GetModeConsumerRunner1.java
package com.nt.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GetModeConsumerRunner1 implements CommandLineRunner {


	@Override
	public void run(String... args) throws Exception {
		//create RestTemplate class obj
		RestTemplate template=new RestTemplate();
		//prepare  service url (or) base url + requestpath
		String  serviceUrl="http://localhost:2020/SpringRestProj14-ProviderApp-PathVariable-JSONData/wish/api/report";
		//invoke the exchnage(...) method
		ResponseEntity<String> response1=template.exchange(serviceUrl,
				                                                                                                      HttpMethod.GET,
				                                                                                                      null, //no body+ headers
				                                                                                                      String.class);
		System.out.println("response body content ::"+response1.getBody());
		System.out.println("response header ::"+response1.getHeaders());
		System.out.println("response status code::"+response1.getStatusCode()+" status code value:"+response1.getStatusCodeValue());
		System.out.println("-----------------------------------------------------------------------------------");
		
		//prepare  service url (or) base url + requestpath
				  serviceUrl="http://localhost:2020/SpringRestProj14-ProviderApp-PathVariable-JSONData/wish/api/message/{id}/{name}";
				//invoke the exchnage(...) method
				ResponseEntity<String> response2=template.exchange(serviceUrl,
						                                                                                                      HttpMethod.GET,
						                                                                                                      null,  //no body+ headers
						                                                                                                      String.class,
						                                                                                                      Map.of("id",1001,"name","rajesh"));
				System.out.println("response body content ::"+response2.getBody());
				System.out.println("response header ::"+response2.getHeaders());
				System.out.println("response status code::"+response2.getStatusCode()+" status code value:"+response2.getStatusCodeValue());
				
		
		
	}

}
