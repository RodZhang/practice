package com.rod.pattern.myproxy;

public class Test {

	public static void main(String[] args) {
		MyInvocationHandler handler = new MyInvocationHandler();
		Animal dog = (Animal) handler.handle(new Dog());
		dog.getName();
	}
}
