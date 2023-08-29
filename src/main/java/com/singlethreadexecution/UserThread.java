package com.singlethreadexecution;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserThread extends Thread {

	private final String name;
	private final String address;
	private final Gate gate;

	@Override
	public void run() {
		System.out.println(name + "BEGIN");
		while (true) {
			gate.pass(name, address);
		}
	}
}
