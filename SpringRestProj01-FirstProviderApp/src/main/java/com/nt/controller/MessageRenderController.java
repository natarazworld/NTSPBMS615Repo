//MessageRenderController.java
package com.nt.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messageapi")  // global path
public class MessageRenderController {
	
	@GetMapping("/wish")  // method path
	public  ResponseEntity<String> showMessage(){
		// get System  Date and time
		LocalDateTime  ldt=LocalDateTime.now();
		// Generate Wish Message
		String msg=null;
		 int hour=ldt.getHour();
		 if(hour<12)
			 msg="Good Morning";
		 else if(hour<16)
			 msg= "Good Afternoon::";
		 else if(hour<20)
			 msg= "Good Eveing::";
		 else 
			 msg="Good Night";
		 // create and return Response Entity object having  response contnet  and status code
		   ResponseEntity< String>  entity=new ResponseEntity<String>(msg,HttpStatus.OK);  //(body, status)
         return 		 entity;
	}
	

}
