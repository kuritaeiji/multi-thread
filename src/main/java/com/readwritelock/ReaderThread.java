package com.readwritelock;

public class ReaderThread extends Thread {

	private final Data data;

	public ReaderThread(String name, Data data) {
		super(name);
		this.data = data;
	}

	@Override
	public void run() {
		while (true) {
			try {
				char[] readBuffer = data.read();
				System.out.println(getName() + " read " + String.valueOf(readBuffer));
			} catch (InterruptedException e) {
			}
		}
	}
}
