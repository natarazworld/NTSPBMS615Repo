package com.nt.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("hsptl")
//@Data
@PropertySource("classpath:input.properties")
public class Hospital {
	
	@Value("KIMS")  //hard coding
	private  String  name;
	@Value("30")  //hard coding
	private  int rank;
	
	@Value("${hsptl.name}")   //collecting from properties file
  private String name1;
	
	@Value("${hsptl.age1}")  //collecting from properties file
	  private int age;	
		
	
	@Value("${Path}")  //injecting from env.. variable
	private  String pathData;
	
	@Value("${os.name}")   // Injecting   system property value  
	private  String os;
	
	/*//@Autowired   //Autowing
	@Value("#{lInfo}")   //using SPEL Perfoming  injection to object type property
	private  LabTestsInfo info;  // HAS -A property
	
	@Value("#{lInfo.bloodProfilePrice+lInfo.rtpcrPrice}")   //SPEL based  arithmetic operation and injection
	private  float  labTestsBillAmt;*/

	@Override
	public String toString() {
		return "Hospital [name=" + name + ", rank=" + rank + ", name1=" + name1 + ", age=" + age + ", pathData="
				+ pathData + ", os=" + os ; // info=" + info + ", labTestsBillAmt=" + labTestsBillAmt + "]";
	}
	
	
	

}
