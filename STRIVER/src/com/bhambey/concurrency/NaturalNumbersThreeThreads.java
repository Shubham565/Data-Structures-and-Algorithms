package com.bhambey.concurrency;

public class NaturalNumbersThreeThreads {

	public static void main(String[] args) {

		PrintSequenceRunnable run1 = new PrintSequenceRunnable(1);
		// PrintSequenceRunnable run2 = new PrintSequenceRunnable(2);
		PrintSequenceRunnable run2 = new PrintSequenceRunnable(0);

		Thread t1 = new Thread(run1, "T1");
		Thread t2 = new Thread(run2, "T2");
		// Thread t3 = new Thread(run3, "T3");

		t1.start();
		t2.start();
		// t3.start();

	}

}

class PrintSequenceRunnable implements Runnable {

	public int LIMIT = 10;
	static int number = 1;
	int remainder;
	static Object lock = new Object();

	PrintSequenceRunnable(int remainder) {
		this.remainder = remainder;
	}

	public void run() {
		while (number < LIMIT - 1) {
			synchronized (lock) {
				while (number % 2 != remainder) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + number);
				number++;
				lock.notifyAll();
			}
		}
	}

}