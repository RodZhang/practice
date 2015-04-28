package com.rod.Reflect;

public class Person implements China {
	public Person() {

	}

	public Person(String name) {
		this.name = name;
	}

	public Person(int age) {
		this.age = age;
	}

	public Person(String name, int age) {
		this.age = age;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "[" + this.name + "  " + this.age + "]";
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	private String name;

	private int age;

	private String sex;

	@Override
	public void sayChina() {
		System.out.println("Hello, China!");
	}

	@Override
	public void sayHello(String name, int age) {
		System.out.println(name + " " + age);
	}
}
