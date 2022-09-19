package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsProj14MiniProjectMsIplPlayerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj14MiniProjectMsIplPlayerServiceApplication.class, args);
	}

}
