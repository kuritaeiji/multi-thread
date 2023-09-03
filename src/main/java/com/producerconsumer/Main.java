package com.producerconsumer;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Table table = new Table(2);

		List<Thread> threads = new ArrayList<>();
		threads.add(new MakerThread("maker 1", table));
		threads.add(new MakerThread("maker 2", table));
		threads.add(new MakerThread("maker 3", table));
		threads.add(new EaterThread("eater 1", table));
		threads.add(new EaterThread("eater 2", table));
		threads.add(new EaterThread("eater 3", table));

		for (Thread thread : threads) {
			thread.start();
		}

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}

		for (Thread thread : threads) {
			thread.interrupt();
		}
	}
}
