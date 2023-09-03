package com.readwritelock;

public class Main {

	public static void main(String[] args) {
		Data data = new Data("**************".toCharArray());
		new WriterThread("writer 1", data, "ABCDEFG").start();
		new WriterThread("writer 2", data, "abcdefg").start();
		new ReaderThread("reader 1", data).start();
		new ReaderThread("reader 2", data).start();
		new ReaderThread("reader 3", data).start();
		new ReaderThread("reader 4", data).start();
		new ReaderThread("reader 5", data).start();
		new ReaderThread("reader 6", data).start();
		new ReaderThread("reader 7", data).start();
	}
}
