package com.rod.pattern.factory.abstractfactory;

import com.rod.pattern.factory.Fruit;

public class AbstractFactory {
	public static Fruit getInstance(String cls) {
		Fruit fruit = null;
		try {
			fruit = (Fruit) Class.forName(cls).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fruit;
	}
}
