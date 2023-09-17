package com.workerthread;

public class ClientThread extends Thread {

	private final Channel channel;

	public ClientThread(String name, Channel channel) {
		super(name);
		this.channel = channel;
	}

	@Override
	public void run() {
		int i = 0;
		try {
			while (true) {
				Request request = new Request(getName(), i);
				channel.put(request);
				i++;
			}
		} catch (InterruptedException e) {
			System.out.println("Worker Thread: " + i);
		}
	}

	public void stopThread() {
		this.interrupt();
	}
}
