package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BootSecurityApp1BasicInMemoryDbApplication {
	
	@Bean
	public  BCryptPasswordEncoder  createPwdEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(BootSecurityApp1BasicInMemoryDbApplication.class, args);
	}

}
