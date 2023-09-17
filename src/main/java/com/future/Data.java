package com.future;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Data {

	private String content;

	public Data(char c, Integer count) {
		char[] buffer = new char[count];
		for (int i = 0; i < count; i++) {
			buffer[i] = c;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
		content = String.valueOf(buffer);
	}
}
