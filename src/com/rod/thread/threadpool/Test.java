package com.rod.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**  
 * @Title: Test.java
 * @Package com.rod.thread.threadpool
 * @Description: TODO(��һ�仰�������ļ���ʲô)
 * @author Rod
 * @date 2015��5��1�� ����11:00:07
 */

public class Test {
	public static void main(String[] args) throws Exception {
		ExecutorService pool = Executors.newFixedThreadPool(2);
		MyCallable c1 = new MyCallable("c1");
		MyCallable c2 = new MyCallable("c2");
		
		// ִ�����񲢻�ȡFuture����
		Future<String> f1 = pool.submit(c1);
		Future<String> f2 = pool.submit(c2);
		
		pool.shutdown();
		// ��ȡ����ֵ
		System.out.println(f1.get());
		System.out.println(f2.get());
	}
}
