package com.nt.beans;

public class Employee1 {
	//all are mandtory to participate
	private int eno;
	private String ename;
	private  float billAmt;
	
	public Employee1(int eno, String ename, float billAmt) {
		System.out.println("Employee1:: 3-param constructor");
		this.eno = eno;
		this.ename = ename;
		this.billAmt =billAmt;
	}
	
		

	@Override
	public String toString() {
		return "Employee1 [eno=" + eno + ", ename=" + ename + ", billAmt=" + billAmt + "]";
	}
	
	
	
	
	
	
}
