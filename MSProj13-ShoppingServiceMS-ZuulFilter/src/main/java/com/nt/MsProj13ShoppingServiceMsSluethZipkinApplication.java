package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsProj13ShoppingServiceMsSluethZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj13ShoppingServiceMsSluethZipkinApplication.class, args);
	}

}
