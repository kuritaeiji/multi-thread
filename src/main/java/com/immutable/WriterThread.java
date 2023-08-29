package com.immutable;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WriterThread extends Thread {

	private final List<Integer> list;

	@Override
	public void run() {
		Integer i = 0;
		while (true) {
			list.add(i);
			list.remove(0);
			i++;
		}
	}
}
