package com.future;

public class Main {

	public static void main(String[] args) {
		// Host host = new Host();
		// FutureData<Data> dataA = host.request('A', 10);
		// FutureData<Data> dataB = host.request('B', 10);
		// FutureData<Data> dataC = host.request('C', 12);

		// try {
		// Thread.sleep(100);
		// } catch (InterruptedException e) {
		// }

		// System.out.println(dataA.getData().getContent());
		// System.out.println(dataB.getData().getContent());
		// System.out.println(dataC.getData().getContent());

		FutureContent<String> yahoo = GetContentHost.request("https://yahoo.co.jp");
		FutureContent<String> google = GetContentHost.request("https://google.com");

		System.out.println(yahoo.getContent());
		System.out.println("\n\n\n\n\n\n");
		System.out.println(google.getContent());
	}
}
