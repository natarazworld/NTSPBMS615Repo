package com.nt.task;

import java.util.Date;
import java.util.TimerTask;

public class Task1 extends TimerTask {

	@Override
	public void run() {
		System.out.println("--------------");
		  System.out.println("from task1:::::"+new Date());
      System.out.println("---------------");
	}

}
