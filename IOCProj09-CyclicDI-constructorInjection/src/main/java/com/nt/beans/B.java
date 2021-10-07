package com.nt.beans;

public class B {
  private A a;
  
  
   public B(A a) {
	   this.a=a;
	System.out.println("B: 1-param constructor");
   }




@Override
public String toString() {
	return "B [a=]";
}
   
   
}
