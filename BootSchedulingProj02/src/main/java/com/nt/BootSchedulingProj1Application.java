package com.nt;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BootSchedulingProj1Application {

	public static void main(String[] args) {
		System.out.println("BootSchedulingProj1Application.main():: App started At::"+new Date());
		SpringApplication.run(BootSchedulingProj1Application.class, args);
	}

}
