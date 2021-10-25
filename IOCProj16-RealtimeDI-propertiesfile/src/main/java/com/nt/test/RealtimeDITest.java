package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import com.nt.controller.MainController;
import com.nt.vo.EmployeeVO;

public class RealtimeDITest {

	public static void main(String[] args) {
		//create IOC container
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get SpringBean class obj ref
		MainController controller=ctx.getBean("controller",MainController.class);
		//read inputs as stirng values and store them into EmployeeVO class object
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter employee name::");
		String  name=sc.next();
		System.out.println("Enter employee desg::");
		String  desg=sc.next();
		System.out.println("Enter employee basicSalary::");
		String  basicSalary=sc.next();
		EmployeeVO vo=new EmployeeVO();
		vo.setEname(name); vo.setDesg(desg); vo.setBasicSalary(basicSalary);
		//invoke methods
		try {
			String result=controller.processEmployee(vo);
			System.out.println(result);
		}
		catch(Exception e) {
			//e.printStackTrace();
			System.out.println("Internal problem::"+e.getMessage());
		}
		
		System.out.println("==================");
		System.out.println(System.getProperties());
		System.out.println("=================");
		Environment env=ctx.getEnvironment();
		System.out.println(env.toString());
		System.out.println(env.getRequiredProperty("os.name"));
		System.out.println(env.getRequiredProperty("jdbc.driver"));
		System.out.println(env.getClass());
		

	}//main
}//class
