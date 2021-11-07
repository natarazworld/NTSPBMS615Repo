package com.nt.service;

public  class BankService {
	
	public final double  caclIntrestAmount(double pamt,double rate,double time){
		System.out.println("BankService.caclIntrestAmount() (compund Intrest)");
		   //calculate  compound intrest amount
		  return    (pamt*Math.pow(1+rate/100, time))-pamt;
	}

}
