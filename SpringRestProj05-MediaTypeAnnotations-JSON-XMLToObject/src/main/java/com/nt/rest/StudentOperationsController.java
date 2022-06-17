//StudentOperationsCotroller.java
package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Student;

@RestController
@RequestMapping("/student/api")
public class StudentOperationsController {
	
	@PostMapping("/register")
	public   ResponseEntity<Student>  registerStudent(@RequestBody Student stud){
		System.out.println("StudentOperationsController.registerStudent()");
		System.out.println("Student obj data ::"+stud);
		return new ResponseEntity<Student>(stud, HttpStatus.CREATED);
	}
	

}
