package com.rod.effective;

/**
 * 使用枚举实现单例
 * @author Arvin
 *
 */
public enum TestSingleton {
	INSTANCE;
	
	public void printInstance() {
		System.out.println(this);
	}
}
