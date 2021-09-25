//BlueDart.java (Dependent class1)
package com.nt.comp;

public final class BlueDart implements Courier {
  
	public BlueDart() {
		System.out.println("BlueDart:: 0-param consturctor");
	}
	
	@Override
	public String deliver(int oid) {
	    return oid+" order id order is delivered by BlueDart";
	}

}
