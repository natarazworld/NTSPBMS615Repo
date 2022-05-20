package com.nt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IExamResult {
	private  Integer id;
	private String dob;
	private  Integer semester;
	private   Float percentage;

}
