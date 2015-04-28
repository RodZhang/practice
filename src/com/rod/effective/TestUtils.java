package com.rod.effective;

/**
 * 工具类最好用这种方式，避免被无用的实例化
 * @author Arvin
 *
 */
public class TestUtils {
	
	// 这是一个工具类，不能被内部方法及其它类的方法实例化
	private TestUtils() {
		throw new AssertionError("This is util class, should't be instance!");
	}
	
	public static String getUtilName() {
		return TestUtils.class.getSimpleName();
	}
	
	public static void test() {
		TestUtils t = new TestUtils();
		System.out.println(t.getUtilName());
	}
}
