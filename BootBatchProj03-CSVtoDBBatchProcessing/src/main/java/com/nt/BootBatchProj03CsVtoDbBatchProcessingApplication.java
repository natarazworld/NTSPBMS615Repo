package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BootBatchProj03CsVtoDbBatchProcessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootBatchProj03CsVtoDbBatchProcessingApplication.class, args);
	}

}
