package com.nt.model;

import lombok.Data;

@Data
public class Student {
	private Integer sno;
	private String sname;
	private String sadd="hyd";
	private Float avg;
	
	public Student() {
		System.out.println("Student:: 0-param consturctor");
	}
	

}
