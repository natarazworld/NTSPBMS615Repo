package com.nt.runner;

import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.Medal;
import com.nt.document.Player;
import com.nt.document.Sport;
import com.nt.service.ISportsMgmtService;

@Component
public class OneToManyAssocationTestRunner implements CommandLineRunner {
	@Autowired
	private  ISportsMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		try {
			 // child class1 objs
			 Sport sport1=new Sport(new Random().nextInt(1000), "badmintton",new String[] {"racket","scock","net"});
			 Sport sport2=new Sport(new Random().nextInt(1000), "tennis",new String[] {"racket","t.ball","net"});
			 
			 //child class2 objs
			 Medal medal1=new Medal("olympic-gold","Gold","Tokyo -olympic","tokyo");
			 Medal medal2=new Medal("cwg-silver","silver","cwg-japan","tokyo");
			 
			 //parent class obj
			 Player player=new Player(new Random().nextInt(1000),
					                                            "sindhu",
					                                            "hyd",
					                                            Set.of(sport1,sport2),
					                                            Map.of("medal1",medal1,"medal2",medal2));
			 //invoke the method
			 System.out.println(service.registerPlayerWithSportsAndMedals(player));
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("===============findAll() operation====================");
		  service.fetchAllPlayersInfo().forEach(per->{
			  System.out.println("parent::"+per);
			  //access child1 objs
			  Set<Sport>  sports=per.getSports();
			  sports.forEach(sport->{
				  System.out.println("child1::"+sport);
			  });
			  //access child2 objs
			  Map<String,Medal> medals=per.getMedals();
			  medals.forEach((type,medal)->{
				  System.out.println("child2::"+type+"....."+medal);
			  });
			  
		  });

	}//main

}//class
