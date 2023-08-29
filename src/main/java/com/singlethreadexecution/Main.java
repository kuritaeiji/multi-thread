package com.singlethreadexecution;

public class Main {

	public static void main(String[] args) {
		// Gate gate = new Gate();
		// new UserThread("Alice", "Alaska", gate).start();
		// new UserThread("Bobby", "Brazil", gate).start();
		// new UserThread("Chris", "Canada", gate).start();

		// BoundedResource boundedResource = new BoundedResource(3);
		// for (int i = 0; i < 10; i++) {
		// new UseLoggerThread(boundedResource).start();
		// }

		Tool spoon = new Tool("spoon");
		Tool folk = new Tool("folk");
		new EaterThread("alice", spoon, folk).start();
		new EaterThread("bob", folk, spoon).start();
	}
}
