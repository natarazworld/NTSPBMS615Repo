package com.nt.config;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@ComponentScan(basePackages = "com.nt.beans")
public class AppConfig {
	
	public AppConfig() {
		System.out.println("AppConfig:: 0-param constructor");
	}
	
	//@Bean(name="sysDate")
	@Bean
	//@Lazy(true)
	public  LocalDateTime   createLDT() {
		System.out.println("AppConfig.createLDT()");   //systrace +ctrl+space : S.o.p(with message)  
	   return  LocalDateTime.now();	
	}

}
