package com.threadpermessage;

public class Helper {

	public void handle(Integer count, char c) {
		System.out.println(Thread.currentThread().getName() + " START");

		for (int i = 0; i < count; i++) {
			System.out.println(c);
			slowly();
		}

		System.out.println(Thread.currentThread().getName() + " END");
	}

	private void slowly() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
	}
}