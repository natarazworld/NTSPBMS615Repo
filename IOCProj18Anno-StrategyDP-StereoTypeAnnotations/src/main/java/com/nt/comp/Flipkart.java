//Fliplkart.java (target class)
package com.nt.comp;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("fpkt")
public final class Flipkart {
	//HAS -A   property of type interface
	@Autowired
	@Qualifier("dtdc")
	private Courier courier;
	
	public Flipkart() {
		System.out.println("Fliplkart:: 0-param constructor");
	}

	
	public  String shopping(String items[], float prices[]) {
		System.out.println(courier);
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
