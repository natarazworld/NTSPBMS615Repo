//YouthCustomer2.java
package com.nt.test;

import com.nt.comp.BudgetCar;
import com.nt.comp.Car;
import com.nt.comp.SportsCar;
import com.nt.factory.CarFactory;

public class YouthCustomer2 {
	public static void main(String[] args) {
		//get Car obj using factory
		Car car=CarFactory.createCar("sports", "TS08 EN 6688");
		car.drive();
		System.out.println("================");
		
	}

}
