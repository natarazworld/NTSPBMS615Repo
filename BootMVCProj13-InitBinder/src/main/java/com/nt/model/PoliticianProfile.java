package com.nt.model;

import java.util.Date;

import lombok.Data;

@Data
public class PoliticianProfile {
	private Integer pid;
	private String pname;
	private  String party;
	private  Date  dob=new Date(100,0,01);
	private  Date  doj;
	private  boolean consPost=false;

}
