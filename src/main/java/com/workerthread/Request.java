package com.workerthread;

import java.util.Random;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Request {

	private final String name;
	private final Integer number;
	private static final Random random = new Random(123456L);

	public void execute() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " execute " + name + " No." + number);
		Thread.sleep(random.nextInt(100));
	}
}
