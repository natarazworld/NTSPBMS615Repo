//PoliticianOperationsController.java
package com.nt.rest;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Politician;

@RestController
@RequestMapping("/politician/api")
public class PoliticianOperationsController {
	
	@GetMapping("/find/{id}")
	public    ResponseEntity<Politician>   findPoliticianById(@PathVariable("id") int id){
		   return  new ResponseEntity<Politician>(new Politician(id, "modi", "bjp", "PM",65.0f),HttpStatus.OK);
	}
	
	@GetMapping("/report")
	public   ResponseEntity<List<Politician>>  showAllPoliticians(){
		  List<Politician> list=List.of(new Politician(1001, "modi", "bjp", "pm", 67.8f),
				                                               new Politician(1002, "amitsha", "bjp", "hm", 67.8f),
				                                               new Politician(1003, "yogi", "bjp", "cm", 61.8f));
		  return  new ResponseEntity<List<Politician>>(list,HttpStatus.OK);
				                                               
	}
	
	@GetMapping("/report1")
	public   ResponseEntity<Map<String,Object>>  showIdCards(){
		  Map<String,Object> map=Map.of("aadhar",54554353,"voterId",35435345,"passport",435435454);
		  return  new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}


	
}
