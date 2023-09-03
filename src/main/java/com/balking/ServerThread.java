package com.balking;

import java.io.IOException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ServerThread extends Thread {

	private final Data data;

	@Override
	public void run() {
		try {
			while (true) {
				data.save();
				Thread.sleep(1000L);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
