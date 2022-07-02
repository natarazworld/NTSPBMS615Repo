//DeleteTouristRunner.java
package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DeleteTouristRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
           //create  RestTemplate class obj
		  RestTemplate template=new RestTemplate();
			//prepare  service url (or) base url + requestpath
			String  serviceUrl="http://localhost:2020/SpringRestProj14-ProviderApp-PathVariable-JSONData/wish/api/delete/{id}"; 
			//send delete mode request
			ResponseEntity<String> response=template.exchange(serviceUrl,
					                                                                                                     HttpMethod.DELETE,
					                                                                                                     null,
					                                                                                                     String.class,
					                                                                                                     101);
			 System.out.println("_______________Delete mode request----------");
		     //process recived response 
		     System.out.println("response body::"+response.getBody());
		     System.out.println("response status code code ::"+response.getStatusCodeValue());
		     System.out.println("response status code  ::"+response.getStatusCode());
		     System.out.println("response headers"+response.getHeaders());
		     System.out.println("_________________________________________");
	}

}
