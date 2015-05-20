package com.rod.effective.annotation;

/**
 * @Title: Sample2.java
 * @Package com.rod.effective.annotation
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Rod
 * @date 2015年5月20日 下午10:50:26
 */

public class Sample2 {
	@ExceptionTest(ArithmeticException.class)
	public static void m1() {
		int i = 0;
		i = i / 1;
	}
	
	@ExceptionTest(ArithmeticException.class)
	public static void m2() {
		int[] a = new int[0];
		int i = a[1];
	}
	
	@ExceptionTest(ArithmeticException.class)
	public static void m3() {
	}
}
