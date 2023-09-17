package com.workerthread;

public class Host {

	public void request(Request request) {
		new Thread(() -> {
			try {
				request.execute();
			} catch (InterruptedException e) {
			}
		}).start();
	}
}
