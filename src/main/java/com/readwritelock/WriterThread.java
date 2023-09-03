package com.readwritelock;

public class WriterThread extends Thread {

	private final Data data;
	private final String filter;
	private Integer index = 0;

	public WriterThread(String name, Data data, String filter) {
		super(name);
		this.data = data;
		this.filter = filter;
	}

	@Override
	public void run() {
		try {
			while (true) {
				data.write(getChar());
				System.out.println(getName() + " write " + getChar());
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
		}
	}

	private char getChar() {
		return filter.charAt(index % filter.length());
	}
}
