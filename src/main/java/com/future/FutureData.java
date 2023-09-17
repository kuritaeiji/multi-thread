package com.future;

public class FutureData<T> {

	private T realData;
	private Boolean ready = false;
	private Exception e = null;

	public synchronized T getData() throws Exception {
		while (!ready) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}

		if (e != null) {
			throw e;
		}

		return realData;
	}

	public synchronized void setData(T data) {
		if (ready) {
			return;
		}

		ready = true;
		realData = data;
		notifyAll();
	}

	public synchronized void setException(Exception e) {
		if (ready) {
			return;
		}

		this.e = e;
		this.ready = true;
		notifyAll();
	}
}
