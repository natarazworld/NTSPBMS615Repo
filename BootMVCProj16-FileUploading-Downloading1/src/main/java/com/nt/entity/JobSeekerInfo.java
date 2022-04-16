package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="BOOT_JS_INFO")
@Data
public class JobSeekerInfo {
	@Id
	@GeneratedValue
	private Integer jsId;
	@Column(length = 15)
	private String jsName;
	@Column(length = 15)
	private String jsAddrs;
	@Column(length = 200)
	private  String resumePath;
	@Column(length = 200)
	private  String photoPath;
	

}
