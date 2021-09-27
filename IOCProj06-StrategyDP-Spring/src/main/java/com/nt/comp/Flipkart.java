//Fliplkart.java (target class)
package com.nt.comp;

import java.util.Arrays;
import java.util.Random;

public final class Flipkart {
	//HAS -A   property of type interface
	private Courier courier;
	
	public Flipkart() {
		System.out.println("Fliplkart:: 0-param constructor");
	}

	//setter method for setter Injection
	public void setCourier(Courier courier) {
		System.out.println("Fliplkart.setCourier(-)");
		this.courier = courier;
	}
	
	public  String shopping(String items[], float prices[]) {
		//caculate billAmt  (b.logic)
		float billAmt=0.0f;
		for(int i=0;i<items.length;++i)
			billAmt=billAmt+prices[i];
		//generate order id
		int oid=new Random().nextInt(100000);
		//use courier for shipping
		String status=courier.deliver(oid);
		String finalMsg=Arrays.toString(items)+"are purchsed with prices"+Arrays.toString(prices)+". The geneated billAmount is::"+billAmt;
		
		return finalMsg+" :::"+status;
	}
	
	 

}
