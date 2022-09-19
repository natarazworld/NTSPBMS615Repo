//IPLOperationsController.java
package com.nt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.IPLTeam;
import com.nt.service.IIPLTeamMgmtService;

@RestController
@RequestMapping("/team")
public class IPLTeamOperationsController {
	@Autowired
	private  IIPLTeamMgmtService teamService;
	
	@PostMapping("/save")
	public  ResponseEntity<String> registerTeam(@RequestBody  IPLTeam team){
		//use serivce
		 String msg=teamService.saveTeam(team);
		 return  new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	
	@GetMapping("/search/{id}")
	public   ResponseEntity<IPLTeam> searchIPLTeamById(@PathVariable("id") int id){
		//use service
		IPLTeam  team=teamService.findTeamById(id);
		return  new ResponseEntity<IPLTeam>(team,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public  ResponseEntity<Iterable<IPLTeam>> showAllTeams(){
		// use service
		  Iterable<IPLTeam> it=  teamService.findAllTeams();
		  return  new ResponseEntity<Iterable<IPLTeam>>(it, HttpStatus.OK);
	}

}
