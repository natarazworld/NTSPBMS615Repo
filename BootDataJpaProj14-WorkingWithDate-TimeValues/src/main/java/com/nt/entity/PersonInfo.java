package com.nt.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Person_Info")
@Data
public class PersonInfo {
	@Id
	@GeneratedValue
	private Integer pid;
	private String pname;
	private Float page;
	private LocalDate dob;
	private LocalTime tob;
	private LocalDateTime doj;
	
	

}
