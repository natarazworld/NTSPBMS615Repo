package com.nt.beans;

public class Customer {
	//cno,cname,billAmt are mandatory properties
	private  int cno;
	private String cname;
	private  float billAmt;
	//caddrs,mobileNo are optional properities
	private String caddrs;
	private long  mobileNo;
	
	public Customer(int cno, String cname, float billAmt) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.billAmt = billAmt;
	}

	public void setCaddrs(String caddrs) {
		this.caddrs = caddrs;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "Customer [cno=" + cno + ", cname=" + cname + ", billAmt=" + billAmt + ", caddrs=" + caddrs
				+ ", mobileNo=" + mobileNo + "]";
	}
	
	
	

}
