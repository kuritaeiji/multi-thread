package com.future;

public class Host {

	public FutureData<Data> request(char c, Integer count) {
		FutureData<Data> futureData = new FutureData<>();
		new Thread(() -> {
			try {
				System.out.println(Thread.currentThread().getName() + " create " + c + " BEGIN ");
				futureData.setData(new Data(c, count));
				System.out.println(Thread.currentThread().getName() + " create " + c + " END ");
			} catch (Exception e) {
				futureData.setException(e);
			}
		}).start();
		return futureData;
	}
}
