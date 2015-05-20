package com.rod.effective.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Title: RunTest.java
 * @Package com.rod.effective.annotation
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Rod
 * @date 2015年5月20日 下午10:10:23
 */

public class RunTest {
	public static void main(String[] args) throws Exception {
		test1();
		test2();
	}
	
	private static void test1() throws Exception {
		int tests = 0;
		int passed = 0;
		Class testClass = Class.forName("com.rod.effective.annotation.Sample");
		for (Method m : testClass.getDeclaredMethods()) {
			if (m.isAnnotationPresent(Test.class)) {
				tests++;
				try {
					m.invoke(null);
					passed++;
				} catch (InvocationTargetException wrappedExc) {
					Throwable exc = wrappedExc.getCause();
					System.out.println(m + "failed: " + exc);
				} catch (Exception exc) {
					System.out.println("INVALID @Test: " + m);
				}
			}
		}
		System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
	}
	
	private static void test2() throws Exception {
		int tests = 0;
		int passed = 0;
		Class testClass = Class.forName("com.rod.effective.annotation.Sample2");
		for (Method m : testClass.getDeclaredMethods()) {
			if (m.isAnnotationPresent(ExceptionTest.class)) {
				tests++;
				try {
					m.invoke(null);
					System.out.printf("Test %s failed: no exception%n", m);
				} catch (InvocationTargetException wrappedExc) {
					Throwable exc = wrappedExc.getCause();
					Class<? extends Exception> excType = m.getAnnotation(ExceptionTest.class).value();
					if (excType.isInstance(excType)) {
						passed++;
					} else {
						System.out.printf("Test %s failed: expected %s, got %s%n", m, excType.getName(), exc);
					}
				} catch (Exception exc) {
					System.out.println("INVALID @Test: " + m);
				}
			}
		}
	}
}
