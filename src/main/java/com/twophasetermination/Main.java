package com.twophasetermination;

public class Main {

	public static void main(String[] args) {
		try {
			CountUpThread thread = new CountUpThread();
			thread.start();

			Thread.sleep(1000);

			thread.requestShutdown();

			thread.join();
			System.out.println("main: END");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
