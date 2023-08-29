package com.immutable;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ReaderThread extends Thread {

	private final List<Integer> list;

	@Override
	public void run() {
		while (true) {
			synchronized (list) {
				for (Integer i : list) {
					System.out.println(i);
				}
			}
		}
	}
}
