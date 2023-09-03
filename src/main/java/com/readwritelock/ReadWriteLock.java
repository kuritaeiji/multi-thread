package com.readwritelock;

public class ReadWriteLock {

	private Integer readingCount = 0;
	private Integer waitingWriterCount = 0;
	private Boolean isWriting = false;
	private Boolean preferWriter = false;

	public synchronized void lockRead() throws InterruptedException {
		while (isWriting || (preferWriter && waitingWriterCount > 0)) {
			wait();
		}

		readingCount++;
	}

	public synchronized void unlockRead() {
		readingCount--;
		preferWriter = true;
		notifyAll();
	}

	public synchronized void lockWrite() throws InterruptedException {
		waitingWriterCount++;
		while (readingCount > 0 || isWriting) {
			wait();
		}

		waitingWriterCount--;

		isWriting = true;
	}

	public synchronized void unlockWrite() {
		isWriting = false;
		preferWriter = false;
		notifyAll();
	}
}
