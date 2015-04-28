package com.rod.pattern.factory.abstractfactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.Properties;

import com.rod.pattern.factory.Fruit;

public class Test {
	public static void main(String[] args) {
		// test1();
		test2();
	}

	public static void test1() {
		Fruit fruit = AbstractFactory
				.getInstance("com.rod.pattern.factory.Apple");
		fruit.eat();
		fruit = AbstractFactory.getInstance("com.rod.pattern.factory.Orange");
		fruit.eat();
	}

	public static void test2() {
		Properties p = getProperties();
		String fruitClass = p.getProperty("apple");
		Fruit fruit = AbstractFactory.getInstance(fruitClass);
		fruit.eat();
		fruit = AbstractFactory.getInstance(p.getProperty("orange"));
		fruit.eat();
	}

	public static Properties getProperties() {
		Properties p = new Properties();
		File file = new File("fruit.properties");
		try {
			if (file.exists()) {
				p.load(new FileInputStream(file));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}
}
