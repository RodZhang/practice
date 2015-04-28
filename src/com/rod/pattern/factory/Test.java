package com.rod.pattern.factory;

public class Test {
	public static void main(String[] args) {
		Fruit fruit = Factory.getInstance("apple");
		fruit.eat();
		fruit = Factory.getInstance("orange");
		fruit.eat();
	}
}
