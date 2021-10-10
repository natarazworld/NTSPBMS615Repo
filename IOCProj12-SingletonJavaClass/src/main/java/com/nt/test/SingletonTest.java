package com.nt.test;

import com.nt.ston.Printer;

public class SingletonTest {

	public static void main(String[] args) {
		 Printer p1=Printer.getInstance();
		 Printer p2=Printer.getInstance();
		 System.out.println(p1.hashCode()+"  "+p2.hashCode());
		 System.out.println("----------------------------");
		 System.out.println("p1==p2"+(p1==p2));
		 

	}

}
