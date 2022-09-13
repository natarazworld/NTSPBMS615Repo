package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class BootKafkaProj1Application {

	public static void main(String[] args) {
		SpringApplication.run(BootKafkaProj1Application.class, args);
	}

}
