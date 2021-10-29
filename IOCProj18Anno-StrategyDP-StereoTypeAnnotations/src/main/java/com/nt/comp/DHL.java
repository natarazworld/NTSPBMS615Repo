//DHL.java (Dependent class1)
package com.nt.comp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("dhl")
public final class DHL implements Courier {
	@Value("${os.name}")
	private String os;
  
	public DHL() {
		System.out.println("DHL:: 0-param consturctor");
	}
	
	@Override
	public String deliver(int oid) {
	    return oid+" order id order is delivered by DHL";
	}

	@Override
	public String toString() {
		return "DHL [os=" + os + "]";
	}
	
	

}
