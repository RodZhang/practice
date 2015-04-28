package com.rod.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test {
	public static void main(String[] args) {
		// test2();
		// test3();
		// test4();
		// test5();
		// test6();
		// test7();
		// test8();
		// test9();
		// test10();
		// test11();
		test12();
	}

	public static void test1() {
		Demo demo = new Demo();
		System.out.println(demo.getClass().getName());
	}

	public static void test2() {
		Class<?> demo1 = null;
		Class<?> demo2 = null;
		Class<?> demo3 = null;

		try {
			demo1 = Class.forName("com.rod.Reflect.Demo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Demo demo = null;
		try {
			demo = (Demo) demo1.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			if (demo != null) {
				System.out.println("demo " + demo.toString());
			}
		}

		demo2 = new Demo().getClass();
		demo3 = Demo.class;

		System.out.println(demo1.getName());
		System.out.println(demo2.getName());
		System.out.println(demo3.getName());
	}

	public static void test3() {
		Class<?> person = null;

		try {
			person = Class.forName("com.rod.Reflect.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Person p1 = null;
		Person p2 = null;
		Person p3 = null;
		Person p4 = null;

		Constructor<?> cons[] = person.getConstructors();
		try {
			p1 = (Person) cons[0].newInstance("Rod", 24);
			p2 = (Person) cons[1].newInstance(24);
			p3 = (Person) cons[2].newInstance("Rod");
			p4 = (Person) cons[3].newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
	}

	public static void test4() {
		Class<?> person = null;

		try {
			person = Class.forName("com.rod.Reflect.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Class<?> interfaces[] = person.getInterfaces();
		for (int i = 0; i < interfaces.length; i++) {
			System.out.println("实现的接口：" + interfaces[i]);
		}
	}

	public static void test5() {
		Class<?> person = getPerson();
		Class<?> superClass = person.getSuperclass();
		System.out.println("super class is " + superClass.getName());
	}

	public static void test6() {
		Class<?> person = getPerson();
		Constructor<?> cons[] = person.getConstructors();
		for (int i = 0; i < cons.length; i++) {
			System.out.println(cons[i]);
		}
	}

	public static void test7() {
		Class<?> person = getPerson();
		Constructor<?> cons[] = person.getConstructors();
		for (int i = 0; i < cons.length; i++) {
			Class<?> p[] = cons[i].getParameterTypes();
			int mod = cons[i].getModifiers();
			System.out.print(Modifier.toString(mod) + " ");
			System.out.print(cons[i].getName() + " (");
			for (int j = 0; j < p.length; j++) {
				System.out.print(p[j].getName() + " arg" + j);
				if (j < p.length - 1) {
					System.out.print(", ");
				}
			}
			System.out.println(") {}");
		}
	}

	public static void test8() {
		Class<?> person = getPerson();
		Method methods[] = person.getMethods();

		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			Class<?> returnType = method.getReturnType();
			Class<?> p[] = method.getParameterTypes();
			Class<?> exceptions[] = method.getExceptionTypes();
			int mod = method.getModifiers();

			System.out.print(Modifier.toString(mod) + " ");
			System.out.print(returnType.getName() + " ");
			System.out.print(method.getName() + "(");
			for (int j = 0; j < p.length; j++) {
				System.out.print(p[j].getName() + " arg" + j);
				if (j < p.length - 1) {
					System.out.print(", ");
				}
			}
			System.out.print(") throws ");
			for (int q = 0; q < exceptions.length; q++) {
				System.out.print(exceptions[q].getName());
				if (q < exceptions.length - 1) {
					System.out.print(", ");
				}
			}
			System.out.println();
		}
	}

	public static void test9() {
		Class<?> person = getPerson();
		System.out.println("===============本类属性========================");
		// 取得全部属性
		Field[] fields = person.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			// 获取权限修饰符
			int mod = field.getModifiers();
			String priv = Modifier.toString(mod);
			// 获取属性类型
			Class<?> type = field.getType();
			System.out.println(priv + " " + type.getName() + " "
					+ field.getName() + ";");
		}
		System.out
				.println("===============实现的接口或者父类的属性========================");
		Field[] superFields = person.getFields();
		for (int i = 0; i < superFields.length; i++) {
			Field field = superFields[i];
			int mod = field.getModifiers();
			String priv = Modifier.toString(mod);
			Class<?> type = field.getType();
			System.out.println(priv + " " + type.getName() + " "
					+ field.getName() + ";");
		}
	}

	/**
	 * 调用其它类的方法
	 */
	public static void test10() {
		Class<?> person = getPerson();
		try {
			Method method = person.getMethod("sayChina");
			method.invoke(person.newInstance());
			method = person.getMethod("sayHello", String.class, int.class);
			method.invoke(person.newInstance(), "Rod", 24);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 调用其它类的set和get方法
	 */
	public static void test11() {
		Class<?> person = getPerson();
		Person p = null;
		try {
			p = (Person) person.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		setter(p, "Sex", "Man", String.class);
		getter(p, "Sex");
	}

	/**
	 * 通过反射操作属性
	 * 
	 * @throws InstantiationException
	 */
	public static void test12() {
		try {
			Person person = (Person) getPerson().newInstance();
			Field field = Person.class.getDeclaredField("sex");
			field.setAccessible(true);
			field.set(person, "Boy");
			System.out.println(field.get(person));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setter(Object obj, String attr, Object value,
			Class<?> type) {
		try {
			Method method = obj.getClass().getMethod("set" + attr, type);
			method.invoke(obj, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getter(Object obj, String attr) {
		try {
			Method method = obj.getClass().getMethod("get" + attr);
			System.out.println(method.invoke(obj));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Class<?> getPerson() {
		Class<?> person = null;

		try {
			person = Class.forName("com.rod.Reflect.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return person;
	}
}
