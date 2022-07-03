// JsonDataConvertorRunner1.java
package com.nt.runner;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonDataConvertorRunner2 implements CommandLineRunner {
	@Autowired
	private  RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
		//prepare  service  url
		String serviceUrl="http://localhost:2020/SpringRestProj15-ProviderApp-JSONtoObject/politician/api/report1";
	    //invoke  rest api/provider  service
		ResponseEntity<String> response=template.exchange(serviceUrl, HttpMethod.GET, null, String.class);
		System.out.println("_________________Map<String,Object>-------------");
		//analyze the response
		System.out.println("response content/body::"+response.getBody());
		System.out.println("response status code::"+response.getStatusCode()+"   "+response.getStatusCodeValue());
		System.out.println("response  headers ::"+response.getHeaders());
		System.out.println("___________JSON to Object convertion_Map<String,Object>_________________");
		ObjectMapper mapper=new ObjectMapper();
		Map<String,Object> map=mapper.readValue(response.getBody(), new TypeReference<Map<String,Object>>() {}); 
		System.out.println("id details map::"+map);
		

	}

}
