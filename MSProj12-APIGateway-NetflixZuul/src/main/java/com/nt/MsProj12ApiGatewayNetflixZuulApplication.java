package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class MsProj12ApiGatewayNetflixZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj12ApiGatewayNetflixZuulApplication.class, args);
	}

}
