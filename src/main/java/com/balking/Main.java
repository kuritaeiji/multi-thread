package com.balking;

public class Main {

	public static void main(String[] args) {
		// Data data = new Data("data.txt");
		// new ChangerThread(data).start();
		// new ServerThread(data).start();

		Host host = new Host(1000L);
		try {
			host.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
