package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsProj01Ms01Application {

	public static void main(String[] args) {
		SpringApplication.run(MsProj01Ms01Application.class, args);
	}

}
