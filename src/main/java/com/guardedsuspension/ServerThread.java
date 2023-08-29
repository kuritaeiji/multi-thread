package com.guardedsuspension;

import java.util.Random;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ServerThread extends Thread {

	private static final Random random = new Random(123456L);
	private final RequestQueue requestQueue;

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			Request request = requestQueue.getRequest();
			System.out.println(Thread.currentThread().getName() + " : " + request);
			try {
				Thread.sleep(random.nextInt(1500));
			} catch (InterruptedException e) {
			}
		}
	}
}
