package com.rod.thread;

public class Bean {
	private int value = 100;
	
	public int getValue() {
		return value;
	}
	
	public void update(int t) {
		value -= t;
	}
}
