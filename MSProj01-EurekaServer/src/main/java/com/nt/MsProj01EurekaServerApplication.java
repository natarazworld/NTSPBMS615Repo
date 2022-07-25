//MsProj01EurekaServerApplication.java
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  //Annotation to activate Eureka Server related configuration EurekaServerAutoConfiguration
public class MsProj01EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj01EurekaServerApplication.class, args);
	}

}
