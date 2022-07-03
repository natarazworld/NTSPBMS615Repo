// JsonDataConvertorRunner.java
package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.model.Politician;

@Component
public class JsonDataConvertorRunner implements CommandLineRunner {
	@Autowired
	private  RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
		//prepare  service  url
		String serviceUrl="http://localhost:2020/SpringRestProj15-ProviderApp-JSONtoObject/politician/api/find/{id}";
	    //invoke  rest api/provider  service
		ResponseEntity<String> response=template.exchange(serviceUrl, HttpMethod.GET, null, String.class,1001);
		//analyze the response
		System.out.println("___________________<T>____________________");
		System.out.println("response content/body::"+response.getBody());
		System.out.println("response status code::"+response.getStatusCode()+"   "+response.getStatusCodeValue());
		System.out.println("response  headers ::"+response.getHeaders());
		System.out.println("_________________________________________");
		//convert the recived json response content into   Java class object  usng  jackson api (DeSerialization)
		 ObjectMapper mapper=new ObjectMapper();
		 Politician politician=mapper.readValue(response.getBody(), Politician.class);
		 System.out.println(" json to object convertion data ::"+politician);

	}

}
