package com.rod.pattern.factory;

public class Factory {
	public static Fruit getInstance(String fruitName) {
		Fruit fruit = null;
		if (fruitName.equals("apple")) {
			fruit = new Apple();
		} else if (fruitName.equals("orange")) {
			fruit = new Orange();
		}
		
		return fruit;
	}
}
