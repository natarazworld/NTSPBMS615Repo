package com.nt.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service("task1")
public class Task1 {
	
	@Scheduled(initialDelay = 10000,fixedDelay = 3000)
	public  void   doTask() {
		System.out.println("task1 ...."+new Date());
	}

}
