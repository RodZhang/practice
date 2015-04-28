package com.rod.pattern.dynamicproxy;

public class RealSubject implements Subject {

	@Override
	public void say(String name, int age) {
		System.out.println(name + " " + age);
	}

}
