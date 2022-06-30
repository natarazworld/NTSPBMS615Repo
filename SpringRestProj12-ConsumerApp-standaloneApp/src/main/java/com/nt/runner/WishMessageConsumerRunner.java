//WishMessageConsumerRunner.java
package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WishMessageConsumerRunner implements CommandLineRunner {
	@Autowired
	private  RestTemplate  template;
	@Value("${service.url}")
	private String serviceUrl;


	@Override
	public void run(String... args) throws Exception {
		//prepare  service url (or) base url + requestpath
		String  serviceUrl="http://localhost:2020/SpringRestProj12-ProviderApp/wish/api/message"; 
		//consume the service using xxxForEntity(-) method
		ResponseEntity<String> response=template.getForEntity(serviceUrl,String.class);
		// process response 
		System.out.println(" response body/payload (output)::"+response.getBody());
		System.out.println("response status code Value::"+response.getStatusCodeValue());
		System.out.println("response Codecode ::"+response.getStatusCode());
		System.out.println("response headers::"+response.getHeaders());
		

	}

}
