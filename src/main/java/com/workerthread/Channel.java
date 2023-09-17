package com.workerthread;

import java.util.ArrayList;
import java.util.List;

public class Channel {

	private final List<WorkerThread> workerThreads = new ArrayList<>();
	private final List<Request> requestQueue = new ArrayList<>();

	private static final Integer maxQueueSize = 100;

	public Channel(Integer workerThreadCount) {
		for (int i = 0; i < workerThreadCount; i++) {
			workerThreads.add(new WorkerThread("Thread-" + i, this));
		}
	}

	public void startWorkers() {
		for (Thread workerThread : workerThreads) {
			workerThread.start();
		}
	}

	public void endWorkers() {
		for (Thread workerThread : workerThreads) {
			workerThread.interrupt();
		}
	}

	public synchronized void put(Request request) throws InterruptedException {
		while (requestQueue.size() > maxQueueSize) {
			wait();
		}

		requestQueue.add(request);
		notifyAll();
	}

	public synchronized Request take() throws InterruptedException {
		while (requestQueue.size() < 1) {
			wait();
		}

		Request request = requestQueue.remove(0);
		notifyAll();
		return request;
	}
}
