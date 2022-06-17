//Company.java
package com.nt.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data   // lombok api annotation
                 //giving   setters, getters , toString,hashCode, equals(-) and etc..
@AllArgsConstructor
public class Company {
	private  String name;
	private  String location;
	private  Integer size;
	private  Double turnOver;
	private  String category;
	

}
