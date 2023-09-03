package com.balking;

import java.io.IOException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ChangerThread extends Thread {

	private final Data data;

	@Override
	public void run() {
		try {
			int i = 0;
			while (true) {
				data.write("No: " + i);
				Thread.sleep(1000L);
				data.save();
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
