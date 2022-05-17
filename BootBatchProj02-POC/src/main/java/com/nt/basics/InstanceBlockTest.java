package com.nt.basics;

class Test{
	public Test() {
		System.out.println("Test: 0-param constructor");
	}
	public void m1() {
		System.out.println("Test: m1() method");
	}
}

public class InstanceBlockTest {

	public static void main(String[] args) {
		  Test  t=new Test();
		  t.m1();
		  System.out.println("__________________");
		  Test  t1=new Test() {  };  // anynomous sub class is created for Test class and that class
		                                             // object is refered its super class (Test)  reference variable
		  t1.m1();
		  System.out.println(t1.getClass()+"  "+t1.getClass().getSuperclass());
		  System.out.println("____________________");
		  
		  Test t2=new Test() {
			  {
				  m1();
			  }
		  };
		  System.out.println(t2.getClass()+"  "+t2.getClass().getSuperclass());

	}

}
