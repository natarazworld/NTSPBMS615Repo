//TouristInfoConsumer_Posting_JsonData.java
package com.nt.runner;


import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class TouristInfoConsumer_Posting_JsonData implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		 //create RestTemplate  object
		RestTemplate template=new RestTemplate();
		//prepare serivce url
		//prepare  service url (or) base url + requestpath
		String  serviceUrl="http://localhost:2020/SpringRestProj13-ProviderApp-PathVariables-JSONData/wish/api/register"; 
		//prepare  HttpHeaders
		   HttpHeaders headers=new HttpHeaders();
		   headers.setContentType(MediaType.APPLICATION_JSON); //optional to specify while sending JSON data
		//prepare HttpRequest as HttpEntity having headers,body
		     String json_body="{ \"tid\":1001,\"tname\":\"raja\",\"startPlace\":\"hyd\",\"destPlace\":\"goa\" }";
		     HttpEntity<String> request=new HttpEntity<String>(json_body, headers);
        // send  POST mode request to  consume rest api service
		     ResponseEntity<String> response=template.postForEntity(serviceUrl, request, String.class);
		     //process recived response 
		     System.out.println("response body::"+response.getBody());
		     System.out.println("response status code code ::"+response.getStatusCodeValue());
		     System.out.println("response status code  ::"+response.getStatusCode());
		     System.out.println("response headers"+response.getHeaders());
		     System.out.println("_________________________________________");
		     
		        // send  POST mode request to  consume rest api service
			     String response1=template.postForObject(serviceUrl, request, String.class);
			     System.out.println("response content/body::"+response1);

		     
		     
		     
		


	}

}
