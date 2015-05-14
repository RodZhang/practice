package com.rod.effective;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

/**  
 * @Title: TestGenerics.java
 * @Package com.rod.effective
 * @Description: 测试泛型
 * @author Rod
 * @date 2015年5月15日 上午12:01:02
 */

public class TestGenerics {
	public static void main(String[] args) {
		test2();
	}
	
	private static void test1() {
		List<String> strings = new ArrayList<String>();
		unsafeAdd(strings, new Integer(42));
		String s = strings.get(0);
		System.out.println(s);
	}
	
	private static void test2() {
		Stack<String> myStack = new Stack<String>();
		myStack.push("world");
		myStack.push(" ");
		myStack.push("hello");
		
		while (!myStack.isEmpty()) {
			System.out.print(myStack.pop());
		}
	}
	
	// 因为List<String> 是原生态类型List的子类，所以可以将strings做为参数传入给这里的list
	// 这里传入不会在编译期间报错，而是在运行期间报ClassCastException异常
	// 但是使用原生态类型会丢失掉泛型在安全性和表述性的优势。
	private static void unsafeAdd(List list, Object o) {
		list.add(o);
	}
	
	// 定义泛型的Stack类，可以将elements声明为Object，然后强制转换成E，使用@SuppressWarnings
	private static class Stack<E> {
		private Object[] elements;
		
		private int size = 0;
		
		private static final int DEFAULT_INITIAL_CAPACITY = 16;
		
		public Stack() {
			elements = new Object[DEFAULT_INITIAL_CAPACITY];
		}
		
		public void push(E e) {
			ensureCapacity();
			elements[size++] = e;
		}
		
		private void ensureCapacity() {
			if (elements.length == size) {
				elements = Arrays.copyOf(elements, 2 * size + 1);
			}
		}
		
		public E pop() {
			if (size == 0) {
				throw new EmptyStackException();
			}
			@SuppressWarnings("unchecked")
			E result = (E) elements[--size];
			elements[size] = null;
			return result;
		}
		
		public boolean isEmpty() {
			return size == 0;
		}
	}
}
