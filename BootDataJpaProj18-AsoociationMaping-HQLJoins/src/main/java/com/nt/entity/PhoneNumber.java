//child class
package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="AM_PHONENUMBERS_DETAILS")
@Setter
@Getter
public class PhoneNumber implements Serializable {
	@Id
	@GeneratedValue
	private Integer regNo;
	private  Long  contactNo;
	@Column(length = 20)
	private  String numberType;
	@Column(length = 20)
	private  String provider; 
	
	public PhoneNumber() {
		System.out.println("PhoneNumber:: 0-param constructor");
	}
	
	   //taking property for FK column any db table is optional
	@Override
	public String toString() {
		return "PhoneNumber(child) [regNo=" + regNo + ", phoneNumber=" + contactNo + ", numberType=" + numberType
				+ ", provider=" + provider + "]";
	}
	
	
	

}
