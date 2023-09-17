package com.workerthread;

public class Main {

	public static void main(String args[]) throws InterruptedException {
		Channel channel = new Channel(5);
		channel.startWorkers();
		Thread clientThread = new ClientThread("client-thread-1", channel);
		clientThread.start();
		new ClientThread("client-thread-2", channel).start();

		Thread.sleep(1000);
		clientThread.interrupt();

		// Host host = new Host();
		// Long now = System.currentTimeMillis();
		// int i = 0;
		// while (now + 1000 > System.currentTimeMillis()) {
		// host.request(new Request("Thread Per Message", i));
		// i++;
		// }
		// System.out.println("Thread Per Message: " + i);
	}
}
