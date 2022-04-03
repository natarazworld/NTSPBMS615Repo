package com.nt.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

@Entity
@Table(name="emp")
@SQLDelete(sql = "UPDATE EMP SET STATUS='inactive' WHERE EMPNO=?")
@Where(clause = "STATUS <> 'inactive' ")
@Data
public class Employee  implements Serializable {
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "emp_id_seq",allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer empno;
	@Column(length = 20)
	private  String ename;
	@Column(length = 20)
	private  String  job;
	private   Float sal;
	private  String status="active";
	@Transient
	private  String vflag="no";
	
}
