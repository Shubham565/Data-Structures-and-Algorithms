package com.bhambey.multithreading;

public class SumMaxIntegers {

	long start;
	long end;
	long sum = 0;
	static long MAX_SUM = Integer.MAX_VALUE;

	public SumMaxIntegers(long start, long end) {
		this.start = start;
		this.end = end;
	}

	public void add() {
		for (long i = start; i < end; i++) {
			sum += i;
		}
	}

	public static void twoThreads() throws InterruptedException {
		long startTime = System.currentTimeMillis();

		SumMaxIntegers smi1 = new SumMaxIntegers(1, MAX_SUM / 2);
		SumMaxIntegers smi2 = new SumMaxIntegers(1 + MAX_SUM / 2, MAX_SUM);

		Thread t1 = new Thread(() -> {
			smi1.add();
		});

		Thread t2 = new Thread(() -> {
			smi2.add();
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		long finalSum = smi1.sum + smi2.sum;
		long endTime = System.currentTimeMillis();
		System.out.println("Two threads gave out final sum as: " + finalSum + " and took " + (endTime - startTime));
	}

	public static void singleThread() {
		long startTime = System.currentTimeMillis();
		SumMaxIntegers smi = new SumMaxIntegers(1, MAX_SUM);
		smi.add();
		long endTime = System.currentTimeMillis();
		System.out.println("Single thread gave out the sum as:  " + smi.sum + " and took " + (endTime - startTime));
	}

	public static void runTest() throws InterruptedException {
		singleThread();
		twoThreads();
	}

	public static void main(String[] args) throws InterruptedException {
		singleThread();
		twoThreads();
	}

}
