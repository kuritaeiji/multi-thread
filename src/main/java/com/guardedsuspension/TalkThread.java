package com.guardedsuspension;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TalkThread extends Thread {

	private final RequestQueue input;
	private final RequestQueue output;

	@Override
	public void run() {
		while (true) {
			Request inputRequest = input.getRequest();
			System.out.println(inputRequest);
			Request outputRequest = new Request(inputRequest.getName() + "!");
			output.addRequest(outputRequest);
		}
	}
}
