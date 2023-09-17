package com.threadpermessage;

import java.io.IOException;

public class Main {

	private static final Helper helper = new Helper();

	public static void main(String[] args) throws IOException {
		System.out.println("main BEGIN");
		// Host host = new Host();
		// host.request(10, 'A');
		// host.request(10, 'B');
		// host.request(10, 'C');
		// new Thread(() -> {
		// printChar(10, 'A');
		// }).start();
		// new Thread(() -> {
		// printChar(10, 'B');
		// }).start();
		// new Thread(() -> {
		// printChar(10, 'C');
		// }).start();
		// helper.handle(10, 'A');
		// helper.handle(10, 'B');
		// try {
		// new MyFrame(new Axios()).clickButton();
		// } catch (InterruptedException e) {
		// }
		new MiniServer().start();
		System.out.println("main END");
	}

	private static void printChar(Integer count, char c) {
		for (int i = 0; i < count; i++) {
			System.out.println(c);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}
