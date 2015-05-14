package com.rod.effective;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

/**  
 * @Title: TestGenerics.java
 * @Package com.rod.effective
 * @Description: ���Է���
 * @author Rod
 * @date 2015��5��15�� ����12:01:02
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
	
	// ��ΪList<String> ��ԭ��̬����List�����࣬���Կ��Խ�strings��Ϊ��������������list
	// ���ﴫ�벻���ڱ����ڼ䱨�������������ڼ䱨ClassCastException�쳣
	// ����ʹ��ԭ��̬���ͻᶪʧ�������ڰ�ȫ�Ժͱ����Ե����ơ�
	private static void unsafeAdd(List list, Object o) {
		list.add(o);
	}
	
	// ���巺�͵�Stack�࣬���Խ�elements����ΪObject��Ȼ��ǿ��ת����E��ʹ��@SuppressWarnings
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
