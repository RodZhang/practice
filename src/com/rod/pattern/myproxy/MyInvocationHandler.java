package com.rod.pattern.myproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {
	
	private Object mObject;
	
	public Object handle(Object object) {
		mObject = object;
		return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.print("Hello, ");
		Object obj = method.invoke(mObject, args);
		System.out.print(", nice to miss you.");
		return obj;
	}

}
