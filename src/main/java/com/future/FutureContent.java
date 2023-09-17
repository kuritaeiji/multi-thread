package com.future;

public class FutureContent<T> {

	private T content;

	public synchronized T getContent() {
		while (content == null) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}

		return content;
	}

	public synchronized void setContent(T content) {
		this.content = content;
		notifyAll();
	}
}
