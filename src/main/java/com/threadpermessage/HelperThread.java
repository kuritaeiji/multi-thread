package com.threadpermessage;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HelperThread extends Thread {

	private final Integer count;
	private final char c;

	@Override
	public void run() {
		for (int i = 0; i < count; i++) {
			System.out.println(c);
		}
	}
}
