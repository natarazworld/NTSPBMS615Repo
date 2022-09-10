//Player.java
package com.nt.model;

import java.io.Serializable;
import java.time.LocalDateTime;


public class Player implements Serializable {
	private Integer pid;
	private  String pname;
	private  LocalDateTime dob;
	private  String sport;	
	
	
	
	public Player(Integer pid, String pname, LocalDateTime dob, String sport) {
	   System.out.println("Player: 4-param constructor");
		this.pid = pid;
		this.pname = pname;
		this.dob = dob;
		this.sport = sport;
	}
	public Player() {
	   System.out.println("Player: 0-param constructor");
	}
	//setters && getters  (alt+shift+s,r)
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public LocalDateTime getDob() {
		return dob;
	}
	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}
	public String getSport() {
		return sport;
	}
	public void setSport(String sport) {
		this.sport = sport;
	}
	
	
	//toString() (alt+shft+s,s)
	
	@Override
	public String toString() {
		return "Player [pid=" + pid + ", pname=" + pname + ", dob=" + dob + ", sport=" + sport + "]";
	}

}
