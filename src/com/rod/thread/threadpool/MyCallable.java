package com.rod.thread.threadpool;

import java.util.concurrent.Callable;

/**  
 * @Title: MyCallable.java
 * @Package com.rod.thread.threadpool
 * @Description: 测试有返回值的线程
 * @author Rod
 * @date 2015年5月1日 下午10:58:33
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
