// IBillingServiceConsumer.java
package com.nt.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("Billing-Service")
public interface IBillingServiceConsumerClient {
	@GetMapping("/billing/api/info")
   public  ResponseEntity<String>  fetchBillingInfo();
}
