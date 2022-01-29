package com.nt.runners;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.PersonInfo;
import com.nt.service.IPersonInfoMgmtService;

@Component
public class DateTimeValuesRunnerTest implements CommandLineRunner {
	@Autowired
	private IPersonInfoMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		PersonInfo info=new PersonInfo();
		info.setPname("rajesh"); info.setPage(23.0f); info.setDob(LocalDate.of(1990,10,23));
		 info.setTob(LocalTime.of(10, 2, 20)); info.setDoj(LocalDateTime.of(2011,10, 30, 11,35));
		 System.out.println(service.registerPErson(info));
		 System.out.println("-------------------------");
		 service.fetchAllPersonDetails().forEach(System.out::println);
		
		
		
	}

}
