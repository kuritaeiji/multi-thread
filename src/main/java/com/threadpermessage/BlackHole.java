package com.threadpermessage;

public class BlackHole {

	public static void enter(Object obj) {
		System.out.println("Step 1");
		magic(obj);
		System.out.println("Step 2");
		synchronized (obj) {
			System.out.println("no reach");
		}
	}

	private static void magic(Object obj) {
		Thread thread = new Thread() {
			@Override
			public void run() {
				synchronized (obj) {
					this.notifyAll();
					while (true) {
					}
				}
			}
		};
		synchronized (thread) {
			thread.start();
			try {
				thread.wait();
			} catch (InterruptedException e) {
			}
		}
	}
}
