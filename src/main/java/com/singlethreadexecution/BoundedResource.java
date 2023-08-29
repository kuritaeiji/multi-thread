package com.singlethreadexecution;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class BoundedResource {

	private final static Random random = new Random(123456);

	private final Semaphore semaphore;
	private final int permits;

	public BoundedResource(int permits) {
		this.permits = permits;
		semaphore = new Semaphore(permits);
	}

	public void use() throws InterruptedException {
		semaphore.acquire();
		try {
			doUse();
		} finally {
			semaphore.release();
		}
	}

	public void doUse() throws InterruptedException {
		Log.println("BEGIN used = " + (permits - semaphore.availablePermits()));
		Thread.sleep(random.nextInt(500));
		Log.println("END used = " + (permits - semaphore.availablePermits()));
	}
}
