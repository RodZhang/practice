package com.rod.effective;

/**
 * ��������������ַ�ʽ�����ⱻ���õ�ʵ����
 * @author Arvin
 *
 */
public class TestUtils {
	
	// ����һ�������࣬���ܱ��ڲ�������������ķ���ʵ����
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
