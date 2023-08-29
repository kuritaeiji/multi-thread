package com.immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// Person person = new Person("Alice", "Alaska");
		// new PrintPersonThread(person).start();
		// new PrintPersonThread(person).start();
		// new PrintPersonThread(person).start();

		List<Integer> list = Collections.synchronizedList(new ArrayList<>());
		new ReaderThread(list).start();
		new WriterThread(list).start();
	}
}
