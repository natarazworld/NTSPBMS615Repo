package com.nt.test;

import java.util.Calendar;
import java.util.Properties;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class FactoryMehodBeanInstantiationTest {

	public static void main(String[] args) {
		//create IOC container
		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get Spring bean class obj
		Class clazz=factory.getBean("c1",Class.class);
		System.out.println("clazz obj  class name::"+clazz.getClass()+" clazz obj data"+clazz.toString());
		System.out.println("----------------------------------");
		Calendar cal=factory.getBean("cal",Calendar.class);
		System.out.println("cal obj  class name::"+cal.getClass()+" cal obj data"+cal.toString());
		System.out.println("-------------------------------------");
		Properties props=factory.getBean("props",Properties.class);
		System.out.println("props obj  class name::"+props.getClass()+" props obj data"+props.toString());
	 System.out.println("===================================");
	      String s2=factory.getBean("s2",String.class);
	      System.out.println("s2 obj class name::"+s2.getClass()+"  s2 obj data ::"+s2);
	      System.out.println("...........................................");
	      String s3=factory.getBean("s3",String.class);
	      System.out.println("s3 obj class name::"+s3.getClass()+"  s3 obj data ::"+s3);

	}

}
