package com.singlethreadexecution;

public class Mutex {

	private int locks = 0;
	private Thread owner;

	public synchronized void lock() {
		while (locks > 0 && Thread.currentThread() != owner) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}

		owner = Thread.currentThread();
		locks++;
	}

	public synchronized void release() {
		if (locks == 0 || Thread.currentThread() != owner) {
			return;
		}

		locks--;
		if (locks == 0) {
			owner = null;
			notifyAll();
		}
	}
}
