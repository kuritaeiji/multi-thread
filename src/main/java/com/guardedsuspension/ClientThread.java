package com.guardedsuspension;

import java.util.Random;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClientThread extends Thread {

	private static final Random random = new Random(123456L);

	private final RequestQueue requestQueue;

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			Request request = new Request("No." + i);
			System.out.println(Thread.currentThread().getName() + " : " + request);
			requestQueue.addRequest(request);
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
			}
		}
	}
}
