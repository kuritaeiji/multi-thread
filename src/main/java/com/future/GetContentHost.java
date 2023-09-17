package com.future;

public class GetContentHost {

	public static FutureContent<String> request(String url) {
		FutureContent<String> futureContent = new FutureContent<>();
		new GetContentThread(url, futureContent).start();
		return futureContent;
	}
}
