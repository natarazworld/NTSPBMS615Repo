package com.nt.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service("task1")
public class Task1 {
	
	//@Scheduled(initialDelay = 10000,fixedDelay = 3000)
	//@Scheduled(fixedDelay = 3000)
	//@Scheduled(fixedDelayString = "3000")
	//@Scheduled(fixedDelay = 3000)
	//@Scheduled(fixedRate = 10000)
	//@Scheduled(initialDelay = 5000 , fixedDelay= 3000,fixedRate = 4000)
	//@Scheduled(cron="0 0  9 * * *")
	//@Scheduled(cron="0 0-59  * * * *")
	//@Scheduled(cron="0  *  * * * *")
	//@Scheduled(cron="0  21,22,24  * * * *")
	//@Scheduled(cron="0/20  *  * * * *")
	//@Scheduled(cron="10/10 8/2  20  * * *")
	@Scheduled(cron="@hourly")
	public  void   doTask() {
		 System.out.println("task1 ...."+new Date());
	}

}
