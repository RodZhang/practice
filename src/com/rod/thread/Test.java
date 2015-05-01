package com.rod.thread;

public class Test {
	public static void main(String[] args) {
		test1();
	}
	
	public static void test1() {
		Bean b = new Bean();
		MyRunnable r = new MyRunnable(b);
		Thread t1 = new Thread(r, "t1");
		Thread t2 = new Thread(r, "t2");
		t1.start();
		t2.start();
	}
}
