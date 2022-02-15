package com.nt.document;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Document
@Setter
@Getter
public class DrivingLicense {
	@NonNull
	@Id
	private Long licenseNo;
	@NonNull
	private String type;
	@NonNull
	private LocalDate expiryTime;
	private  Person personDetails;
	
	
	@Override
	public String toString() {
		return "DrivingLicense [ licenseNo=" + licenseNo + ", type=" + type + ", expiryTime=" + expiryTime + "]";
	}
	
	
	
	
	
	

}
