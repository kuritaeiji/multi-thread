package com.singlethreadexecution;

import java.util.Random;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UseLoggerThread extends Thread {

	private final static Random random = new Random(12345);

	private final BoundedResource boundedResource;

	@Override
	public void run() {
		try {
			while (true) {
				boundedResource.use();
				Thread.sleep(random.nextInt(3000));
			}
		} catch (InterruptedException e) {
		}
	}
}
