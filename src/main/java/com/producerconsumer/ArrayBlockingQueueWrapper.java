package com.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueWrapper<T> {

	private final ArrayBlockingQueue<T> queue;

	public ArrayBlockingQueueWrapper(Integer queueMaxSize) {
		queue = new ArrayBlockingQueue<>(queueMaxSize);
	}

	public void put(T item) throws InterruptedException {
		queue.put(item);
	}

	public T take() throws InterruptedException {
		return queue.take();
	}
}
