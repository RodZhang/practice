package com.rod.effective.annotation;

/**
 * @Title: Sample.java
 * @Package com.rod.effective.annotation
 * @Description: TODO(��һ�仰�������ļ���ʲô)
 * @author Rod
 * @date 2015��5��20�� ����10:09:47
 */

public class Sample {
	@Test
	public static void m1() {
	}

	public static void m2() {
	}

	@Test
	public static void m3() {
		throw new RuntimeException("Boom");
	}

	public static void m4() {
	}

	@Test
	public void m5() {
	}

	public static void m6() {
	}

	@Test
	public static void m7() {
		throw new RuntimeException("Crash");
	}

	public static void m8() {
	}
}
