package com.balking;

import java.util.concurrent.TimeoutException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Host {

	private final Long timeout;
	private boolean executable = false;

	public synchronized void setExecutable() {
		executable = true;
	}

	public synchronized void execute() throws InterruptedException, TimeoutException {
		Long start = System.currentTimeMillis();
		while (!executable) {
			Long rest = timeout - (System.currentTimeMillis() - start);
			if (rest <= 0) {
				throw new TimeoutException(Thread.currentThread().getName() + " rest: " + rest + "ms");
			}
			wait(rest);
		}

		doExecute();
	}

	private void doExecute() {
		System.out.println(Thread.currentThread().getName() + "execute");
	}
}
