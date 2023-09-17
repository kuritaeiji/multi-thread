package com.twophasetermination;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class CountUpThread extends Thread {

	private long counter = 0;

	private boolean isShutdown = false;

	@Override
	public void run() {
		try {
			while (!isShutdown) {
				doRun();
			}
		} catch (InterruptedException e) {
		} finally {
			doShutdown();
		}
	}

	public void requestShutdown() {
		isShutdown = true;
		interrupt();
	}

	private void doRun() throws InterruptedException {
		counter++;
		System.out.println("doRun: counter = " + counter);
		Thread.sleep(500);
	}

	private void doShutdown() {
		System.out.println("doShutdown: counter = " + counter);

		try (FileWriter writer = new FileWriter("counter.txt")) {
			writer.write("counter " + counter);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
