package com.bhambey.multithreading;

public class Deadlock {

	int counter = 0;
	private Object lock1 = new Object();
	private Object lock2 = new Object();

	void incrementCounter() throws InterruptedException {
		synchronized (lock1) {
			System.out.println("Acquired lock1");
			Thread.sleep(100);
			synchronized (lock2) {
				counter++;
			}
		}
	}

	void decrementCounter() throws InterruptedException {
		synchronized (lock2) {
			System.out.println("Acquired lock2");
			Thread.sleep(100);

			synchronized (lock1) {
				counter--;
			}
		}
	}

	Thread t1 = new Thread(() -> {
		for (int i = 0; i < 100; i++) {
			try {
				decrementCounter();
				System.out.println("Decrementing: " + i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	});

	Thread t2 = new Thread(() -> {
		for (int i = 0; i < 100; i++) {
			try {
				incrementCounter();
				System.out.println("Incrementing: " + i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	});
	
	public void runTest() throws InterruptedException
	{
		t1.start();
		Thread.sleep(100);
		
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Done : " + counter);
	}

}
