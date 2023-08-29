package com.singlethreadexecution;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EaterThread extends Thread {

	private final String name;
	private final Tool left;
	private final Tool right;

	@Override
	public void run() {
		while (true) {
			synchronized (left) {
				System.out.println(name + " takes up " + left + " (left) ");
				synchronized (right) {
					System.out.println(name + " takes up " + right + " (right) ");
					System.out.println(name + " puts down " + right + " (right) ");
				}
				System.out.println(name + " puts down " + left + " (left) ");
			}
		}
	}
}
