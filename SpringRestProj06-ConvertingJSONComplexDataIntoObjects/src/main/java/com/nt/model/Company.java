//Company.java
package com.nt.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Company {
	private Long companyId;
	private String companyName;
	@JsonFormat(pattern = "yyyy-MM-dd")  //optional for this pattern
	private  LocalDate dos;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  //option for this pattern
	private LocalDateTime dtos;
	private  List<Project> projectsInfo;
	@JsonFormat(pattern = "HH:mm:ss")  //option for this pattern
	private  LocalTime tos;
 
}
