//StrategyDPTest.java
package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.comp.DHL;
import com.nt.comp.Flipkart;

import in.nt.comp1.TestBean;

public class StrategyDPTest {

	public static void main(String[] args) {
		//create IOC container
		 ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		 //get Target class obj
		 Flipkart fpkt=ctx.getBean("fpkt",Flipkart.class);
		 //invoke the b.method
		 String resultMsg=fpkt.shopping(new String[] {"shirt","trouser","glasses"},
				                                                new float[] {5679.60f,5557.55f,4545.77f} );
		 System.out.println(resultMsg);
		 System.out.println(".......................");
		 DHL dhl=ctx.getBean("dhl",DHL.class);
		 System.out.println(dhl);
		 System.out.println("......................");
		 
		 TestBean tb=ctx.getBean("tb",TestBean.class);
		 System.out.println(tb);
		 
	}//main
}//class
