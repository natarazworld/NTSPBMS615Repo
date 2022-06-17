//Employee.java
package com.nt.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class Employee {
	private  Integer empno;
	private  String empname;
	private  Address  empaddrs;  // HAS- property 2D Array
	private  String[]  favColors;  //1D array
	private  List<String> nickNames;  // 1D array
	private  Set<Long> phoneNumbers;  // 1D Array
	private Map<String,Long> idDetails;  // 2D Array
}
