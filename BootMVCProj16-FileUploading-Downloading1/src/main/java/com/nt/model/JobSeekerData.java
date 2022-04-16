//JobSeekerData.java
package com.nt.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;


@Data
public class JobSeekerData implements Serializable {
	private Integer jsId;
	private String jsName;
	private String jsAddrs;
	private  MultipartFile resume;  //Input stream to hold content of uploded file
	private  MultipartFile photo;
	

}
