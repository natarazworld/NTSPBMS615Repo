//DHL.java (Dependent class1)
package com.nt.comp;

public final class DHL implements Courier {
  
	public DHL() {
		System.out.println("DHL:: 0-param consturctor");
	}
	
	@Override
	public String deliver(int oid) {
	    return oid+" order id order is delivered by DHL";
	}

}
