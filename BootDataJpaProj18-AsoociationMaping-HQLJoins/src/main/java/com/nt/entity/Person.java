package com.nt.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="AM_PERSON_DETAILS")
@Setter
@Getter
public class Person implements Serializable {
	@Id
	@SequenceGenerator(name = "gen1",initialValue = 1000,allocationSize = 1,sequenceName = "PID_SEQ1")
	@GeneratedValue(generator = "gen1",strategy =GenerationType.SEQUENCE )
	private  Integer pid;
	@Column(length = 20)
	private String  pname;
	@Column(length = 20)
   private  String  paddrs;
	@OneToMany(targetEntity = PhoneNumber.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "PERSON_ID",referencedColumnName = "PID")
	private Set<PhoneNumber> phonesInfo;
	
	public Person() {
		System.out.println("Person:: 0-param constructor");
	}
	
	@Override
	public String toString() {
		return "Person(parent) [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + "]";
	}
	
	

}
