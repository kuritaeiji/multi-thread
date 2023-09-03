package com.readwritelock;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Data {

	private final char[] buffer;
	private final ReadWriteLock lock = new ReadWriteLock();

	public char[] read() throws InterruptedException {
		lock.lockRead();
		try {
			return doRead();
		} finally {
			lock.unlockRead();
		}
	}

	private char[] doRead() {
		char[] newBuffer = new char[buffer.length];
		for (int i = 0; i < newBuffer.length; i++) {
			newBuffer[i] = buffer[i];
		}

		return newBuffer;
	}

	public void write(char c) throws InterruptedException {
		lock.lockWrite();
		try {
			doWrite(c);
		} finally {
			lock.unlockWrite();
		}
	}

	private void doWrite(char c) throws InterruptedException {
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = c;
		}
		Thread.sleep(50);
	}
}
