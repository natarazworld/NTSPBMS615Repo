package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsProj12EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj12EurekaServerApplication.class, args);
	}

}
