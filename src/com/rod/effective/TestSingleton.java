package com.rod.effective;

/**
 * ʹ��ö��ʵ�ֵ���
 * @author Arvin
 *
 */
public enum TestSingleton {
	INSTANCE;
	
	public void printInstance() {
		System.out.println(this);
	}
}
