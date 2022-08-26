package com.nt.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
	
	public static void main(String[] args) throws Exception {
		 BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		  String pwd1=encoder.encode("rani");
		  String pwd2=encoder.encode("hyd");
		  String pwd3=encoder.encode("begum");
		  String pwd4=encoder.encode("delhi");
		  System.out.println(pwd1);
		  System.out.println(pwd2);
		  System.out.println(pwd3);
		  System.out.println(pwd4);
		  
		  	  
	}

}
