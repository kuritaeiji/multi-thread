package com.guardedsuspension;

public class Main {

	public static void main(String[] args) throws Exception {
		// RequestQueue requestQueue = new RequestQueue();
		// new ClientThread(requestQueue).start();
		// new ServerThread(requestQueue).start();

		RequestQueue requestQueue1 = new RequestQueue();
		RequestQueue requestQueue2 = new RequestQueue();

		new TalkThread(requestQueue1, requestQueue2).start();
		new TalkThread(requestQueue2, requestQueue1).start();
		// requestQueue1.addRequest(new Request("hello"));
	}
}
