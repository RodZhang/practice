package com.rod.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**  
 * @Title: Test.java
 * @Package com.rod.thread.threadpool
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Rod
 * @date 2015年5月1日 下午11:00:07
 */

public class Test {
	public static void main(String[] args) throws Exception {
		ExecutorService pool = Executors.newFixedThreadPool(2);
		MyCallable c1 = new MyCallable("c1");
		MyCallable c2 = new MyCallable("c2");
		
		// 执行任务并获取Future对象
		Future<String> f1 = pool.submit(c1);
		Future<String> f2 = pool.submit(c2);
		
		pool.shutdown();
		// 获取返回值
		System.out.println(f1.get());
		System.out.println(f2.get());
	}
}
