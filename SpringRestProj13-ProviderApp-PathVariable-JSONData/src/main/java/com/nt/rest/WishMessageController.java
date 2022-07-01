//WishMessageController.java
package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Tourist;

@RestController
@RequestMapping("/wish/api")
public class WishMessageController {
	
	@GetMapping("/message/{id}/{name}")
	public ResponseEntity<String>  showWishMessage(@PathVariable("id") int id,
			                                                                                              @PathVariable("name") String name){
		System.out.println(id + "------"+name);
		return new ResponseEntity<String>("Good Night::"+id+"--- "+name,HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public   ResponseEntity<String>  registerTourist(@RequestBody Tourist  tourist){
		System.out.println("WishMessageController.registerTourist() ::"+ tourist);
		return new ResponseEntity<String>("tourist Info::"+tourist.toString(),HttpStatus.CREATED);
	}

}
