package com.immutable;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PrintPersonThread extends Thread {

	private final Person person;

	@Override
	public void run() {
		while (true) {
			System.out.println(Thread.currentThread().getName() + person.toString());
		}
	}
}
