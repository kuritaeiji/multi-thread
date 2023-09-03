package com.producerconsumer;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Table {

	private final List<String> queue = new ArrayList<>();
	private final Integer maxSize;

	public synchronized void put(String cake) throws InterruptedException {
		while (queue.size() > maxSize) {
			wait();
		}

		queue.add(cake);
		notifyAll();
	}

	public synchronized String take() throws InterruptedException {
		while (queue.size() < 1) {
			wait();
		}

		String cake = queue.get(0);
		queue.remove(0);
		notifyAll();
		return cake;
	}

	public synchronized void clear() {
		queue.removeAll(queue);
		notifyAll();
	}
}
