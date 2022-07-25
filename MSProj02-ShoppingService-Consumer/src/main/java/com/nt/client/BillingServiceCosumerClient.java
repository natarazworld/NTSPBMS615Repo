//BillingServiceCosumerClient .java (Client App)
package com.nt.client;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceCosumerClient {
	@Autowired
	private  DiscoveryClient client;
	
	  public   String   getBillingInfo() {
		  // Get Billing-Service  Instance from eureka server
		  List<ServiceInstance> listInstances=client.getInstances("Billing-Service");
		  // get Single Instance from List of Instnace  (no load balacing)
		   ServiceInstance instance=listInstances.get(0);
		   // get details from Serivce Instance
		   URI uri=instance.getUri();
			//prepare  provider MS related url to cosume method 
		  String url=uri.toString()+"/billing/api/info";
		  
		 //create RestTemplate class obj to cosume the provider  service
		    RestTemplate template=new RestTemplate();
		 //  consume the provider service
		    ResponseEntity<String> response=template.getForEntity(url,String.class);
		   // get response content from ResponseEntity object
		    String responseContent=response.getBody();
		  
		    return responseContent;
		  
	  }

}
