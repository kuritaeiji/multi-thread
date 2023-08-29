package com.guardedsuspension;

import java.util.ArrayList;
import java.util.List;

public class RequestQueue {

	private final List<Request> requestQueue = new ArrayList<>();

	public synchronized Request getRequest() {
		while (requestQueue.isEmpty()) {
			try {
				wait();
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
