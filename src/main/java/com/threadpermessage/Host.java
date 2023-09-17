package com.threadpermessage;

public class Host {

	private static final Helper helper = new Helper();

	public void request(Integer count, char c) {
		// new Thread() {
		// @Override
		// public void run() {
		// helper.handle(count, c);
		// }
		// }.start();
		new HelperThread(count, c).start();
	}
}
