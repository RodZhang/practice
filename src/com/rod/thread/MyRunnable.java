package com.rod.thread;

public class MyRunnable implements Runnable {

	private static final byte[] mLock = new byte[0];

	private Bean bean;

	public MyRunnable(Bean bean) {
		this.bean = bean;
	}

	@Override
	public void run() {
		synchronized (mLock) {
			for (int i = 0; i < 2; i++) {
				bean.update(20);
				System.out.println(Thread.currentThread().getName()
						+ "-- bean.value=" + bean.getValue());
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
