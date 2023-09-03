package com.producerconsumer;

import java.util.Random;

public class MakerThread extends Thread {

	private final Table table;

	public MakerThread(String name, Table table) {
		super(name);
		this.table = table;
	}

	@Override
	public void run() {
		int i = 0;
		try {
			while (true) {
				Thread.sleep(new Random().nextInt(1000));
				table.put(i + "cake made by " + Thread.currentThread().getName());
				System.out.println(Thread.currentThread().getName() + " make " + i + " cake ");
				i++;
			}
		} catch (InterruptedException e) {
		}
	}
}
