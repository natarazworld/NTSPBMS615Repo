//ProfessionalCustomer1.java
package com.nt.test;

import com.nt.comp.BudgetCar;
import com.nt.comp.Car;
import com.nt.factory.CarFactory;

public class ProfessionalCustomer1 {
	public static void main(String[] args) {
		//get Car obj using factory
			Car car=CarFactory.createCar("budget", "TS09 EN 5688");
			car.drive();
			System.out.println("================");
	}

}
