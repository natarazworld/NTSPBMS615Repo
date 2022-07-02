//DeleteTouristRunner.java
package com.nt.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DeleteTouristRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
           //create  RestTemplate class obj
		  RestTemplate template=new RestTemplate();
			//prepare  service url (or) base url + requestpath
			String  serviceUrl="http://localhost:2020/SpringRestProj13-ProviderApp-PathVariables-JSONData/wish/api/delete/{id}"; 
			//send delete mode request
			template.delete(serviceUrl, Map.of("id",1001));  //delete(-) method return type is void
			System.out.println("delete operation is completed");
	}

}
