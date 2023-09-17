package com.workerthread;

public class WorkerThread extends Thread {

	private final Channel channel;

	public WorkerThread(String name, Channel channel) {
		super(name);
		this.channel = channel;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Request request = channel.take();
				request.execute();
			}
		} catch (InterruptedException e) {
		}
	}
}
