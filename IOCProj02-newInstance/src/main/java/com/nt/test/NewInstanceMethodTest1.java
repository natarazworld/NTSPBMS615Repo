//NewInstanceMethodTest1 .java
package com.nt.test;

import java.lang.reflect.Constructor;

public class NewInstanceMethodTest1 {

	public static void main(String[] args) throws Exception{
		//Load classes
		 Class c1=Class.forName(args[0]);
		 //get All constructor of  the Loaded class
		 Constructor cons[]=c1.getDeclaredConstructors();
		 //Dynamic object using 0-param constructor
		 cons[0].setAccessible(true);  //gives access to private constructor
		 Object obj1=cons[0].newInstance();
		 System.out.println(obj1);
		 System.out.println("......................");
		 //Dynamic object using 2-param constructor
		 cons[1].setAccessible(true);  //gives access to private constructor
		 Object obj2=cons[1].newInstance(100,"india");
		 System.out.println(obj2);
	}

}
