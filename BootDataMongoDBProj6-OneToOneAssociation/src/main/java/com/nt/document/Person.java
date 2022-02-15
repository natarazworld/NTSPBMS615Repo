package com.nt.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Document
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Person {
	@Id
	@NonNull
	private Integer pid;
	@NonNull
	private String name;
	@NonNull
	private String addrs;
	private DrivingLicense licenseDetails;
	
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", name=" + name + ", addrs=" + addrs + "]";
	}

}
