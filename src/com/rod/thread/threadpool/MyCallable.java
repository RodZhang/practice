package com.rod.thread.threadpool;

import java.util.concurrent.Callable;

/**  
 * @Title: MyCallable.java
 * @Package com.rod.thread.threadpool
 * @Description: �����з���ֵ���߳�
 * @author Rod
 * @date 2015��5��1�� ����10:58:33
 */

public class MyCallable implements Callable<String> {
	
	private String name;
	
	public MyCallable(String name) {
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		return name + " call.";
	}

}
