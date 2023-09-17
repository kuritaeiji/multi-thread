package com.threadpermessage;

import java.util.Map;

public class Axios {

	public synchronized void post(Map<String, String> params) throws InterruptedException {
		new Thread(() -> {
			System.out.println("axios post " + params);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			System.out.println("axios posted " + params);
		}).start();
	}
}
