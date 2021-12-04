package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("emp")
@ConfigurationProperties(prefix = "emp.details")
@Data
public class Employee {
	//spring bean properties
	@Value("${emp.info.name}")
	private String  name;
	private int  age;
	
	Employee(){
		System.out.println("Employee::0-param construtor ::"+name);
	}
	
	public void setName(String name) {
		System.out.println(this.name);
		this.name=name;
		System.out.println("Employee.SetName(-) ::"+name);
	}
	
	
	
	
	

}
