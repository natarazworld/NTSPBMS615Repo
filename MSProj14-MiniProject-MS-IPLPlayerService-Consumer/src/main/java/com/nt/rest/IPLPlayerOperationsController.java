package com.nt.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.IPLPlayer;
import com.nt.service.IIPLPlayMgmtService;

@RestController
@RequestMapping("/player")
public class IPLPlayerOperationsController {
	private static  Logger logger= LoggerFactory.getLogger(IPLPlayerOperationsController.class);
	 @Autowired
	private  IIPLPlayMgmtService  playerService;
	 
	 @PostMapping("/save")
	 public  ResponseEntity<String>  registerPlayer(@RequestBody IPLPlayer player){
		 //use service
		 String msg=playerService.registerPlayer(player);
		  logger.info("Rest Controller :: requst came from  Player saving:");
		 return  new ResponseEntity<String>(msg,HttpStatus.CREATED);
	 }
	 
	 @GetMapping("/all")
	 public   ResponseEntity<Iterable<IPLPlayer>>  showAllPlayers(){
		 Iterable<IPLPlayer>  list= playerService.showAllPlayers();
		 logger.info("Rest Controller :: requst came for  showing all players:");
		 return  new ResponseEntity<Iterable<IPLPlayer>>(list,HttpStatus.OK);
	 }
	 
	 

}
