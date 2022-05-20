package com.nt.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="SUPER_TOP_BRAINS")
public class OExamResult {
	@Id
	private  Integer id;
	private LocalDate dob;
	private  Integer semester;
	private   Float percentage;

}
