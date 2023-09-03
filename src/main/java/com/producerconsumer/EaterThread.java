package com.producerconsumer;

import java.util.Random;

public class EaterThread extends Thread {

	private final Table table;

	public EaterThread(String name, Table table) {
		super(name);
		this.table = table;
	}

	@Override
	public void run() {
		try {
			while (true) {
				String cake = table.take();
				Thread.sleep(new Random().nextInt(1000));
				System.out.println(Thread.currentThread().getName() + " eat " + cake);
			}
		} catch (InterruptedException e) {
			System.out.println("終了");
		}
	}
}
