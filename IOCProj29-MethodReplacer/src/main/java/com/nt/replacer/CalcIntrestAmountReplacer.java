package com.nt.replacer;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class CalcIntrestAmountReplacer implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("CalcIntrestAmountReplacer.reimplement() (Simple intrest )");
		//get target method arg values//
		double  pamt=(double)args[0];
		double  rate=(double)args[1];
		double time=(double)args[2];
		//wirte new logic to execute (simpleIntrest amount)
		return  pamt*rate*time/100;
	}

}
