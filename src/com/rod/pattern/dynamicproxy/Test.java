package com.rod.pattern.dynamicproxy;

public class Test {
	public static void main(String[] args) {
		MyInvocationHandler handler = new MyInvocationHandler();
		Subject subject = (Subject) handler.bind(new RealSubject());
		subject.say("Rod", 24);
	}
}
