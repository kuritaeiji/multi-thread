package com.guardedsuspension;

import java.util.ArrayList;
import java.util.List;

public class RequestQueue {

	private final List<Request> requestQueue = new ArrayList<>();

	public synchronized Request getRequest() {
		Long start = System.currentTimeMillis();
		while (requestQueue.isEmpty()) {
			Long rest = 10000 - (System.currentTimeMillis() - start);
			if (rest < 0) {
				throw new LivenessException(Thread.currentThread().getName() + rest + "ms");
			}
			try {
				wait(rest);
			} catch (InterruptedException e) {
			}
		}
		return requestQueue.remove(requestQueue.size() - 1);
	}

	public synchronized void addRequest(Request request) {
		requestQueue.add(request);
		notifyAll();
	}
}
