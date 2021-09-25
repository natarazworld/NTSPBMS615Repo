//FlipkartFactory.java
package com.nt.factory;

import com.nt.comp.BlueDart;
import com.nt.comp.Courier;
import com.nt.comp.DTDC;
import com.nt.comp.Flipkart;

public class FlipkartFactory {

	 //static factory method supporting Factory pattern
	public static   Flipkart  createFlipkart(String courierType) {
		    //create target class obj
		    Flipkart fpkt=new Flipkart();
		    Courier courier=null;
		    //create Depennt class obj based on given courier type
		    if(courierType.equalsIgnoreCase("dtdc"))
		    	courier=new DTDC();
		    else if(courierType.equalsIgnoreCase("bDart"))
		    	courier=new BlueDart();
		    else
		    	  throw new IllegalArgumentException("Invalid courier type");
		    //set  Dependent class object to target class obj
		       fpkt.setCourier(courier);
	       return fpkt;
     }
	
	
}
