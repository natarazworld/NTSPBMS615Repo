// JsonDataConvertorRunner1.java
package com.nt.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.model.Politician;

@Component
public class JsonDataConvertorRunner1 implements CommandLineRunner {
	@Autowired
	private  RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
		//prepare  service  url
		String serviceUrl="http://localhost:2020/SpringRestProj15-ProviderApp-JSONtoObject/politician/api/report";
	    //invoke  rest api/provider  service
		ResponseEntity<String> response=template.exchange(serviceUrl, HttpMethod.GET, null, String.class);
		System.out.println("_________________List<T>-------------");
		//analyze the response
		System.out.println("response content/body::"+response.getBody());
		System.out.println("response status code::"+response.getStatusCode()+"   "+response.getStatusCodeValue());
		System.out.println("response  headers ::"+response.getHeaders());
		System.out.println("___________JSON to Object convertion_List<T>_________________");
		ObjectMapper mapper=new ObjectMapper();
		Politician  politicians[]=mapper.readValue(response.getBody(), Politician[].class);  //converts  1D array to  java array
		List<Politician> list=Arrays.asList(politicians);
		list.forEach(System.out::println);
		System.out.println("....................");
		List<Politician> list1=mapper.readValue(response.getBody(), new TypeReference<List<Politician>>() {}); 
		list1.forEach(System.out::println);

	}

}
