package com.future;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class GetContentThread extends Thread {

	private final String url;
	private final FutureContent<String> futureContent;

	public GetContentThread(String url, FutureContent<String> futureContent) {
		this.url = url;
		this.futureContent = futureContent;
	}

	@Override
	public void run() {
		try {
			URL urlObj = new URL(url);
			StringBuilder builder = new StringBuilder();
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(urlObj.openStream()))) {
				String line = reader.readLine();
				while (line != null) {
					builder.append(line);
					line = reader.readLine();
				}
				futureContent.setContent(builder.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
