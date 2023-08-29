package com.singlethreadexecution;

import lombok.ToString;

@ToString
public class Gate {

	private Long counter = 0L;
	private String name;
	private String address;

	public void pass(String name, String address) {
		counter++;
		this.name = name;
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}
		this.address = address;
		check();
	}

	private void check() {
		if (name.charAt(0) != address.charAt(0)) {
			System.out.println("******Broken******" + toString());
		}
	}
}
