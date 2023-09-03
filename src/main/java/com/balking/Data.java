package com.balking;

import java.io.FileWriter;
import java.io.IOException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Data {
	private final String filename;
	private String content = "";
	private Boolean changed = false;

	public synchronized void write(String addingContent) {
		content += addingContent;
		changed = true;
	}

	public synchronized void save() throws IOException {
		if (!changed) {
			return;
		}

		doSave();
		changed = false;
	}

	private void doSave() throws IOException {
		try (FileWriter fileWriter = new FileWriter(filename)) {
			System.out.println(Thread.currentThread().getName() + content);
			fileWriter.write(content);
		}
	}
}
