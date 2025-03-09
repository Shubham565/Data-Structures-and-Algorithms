package com.bhambey.concurrency;

public class PrintOddEven {
	static int N;
	int count = 1;

	public void printEven() {
		while (count < N) {
			synchronized (this) {

				while (count % 2 == 1) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Even: " + count + " ");
				count++;
				notify();

			}
		}
	}

	public void printOdd() {
		while (count < N) {
			synchronized (this) {

				while (count % 2 == 0) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Odd: " + count + " ");
				count++;
				notify();
			}
		}

	}

	public static void main(String[] args) {
		N = 10;

		PrintOddEven poe = new PrintOddEven();

		Thread T1 = new Thread(new Runnable() {
			public void run() {
				poe.printEven();
			}
		});

		Thread T2 = new Thread(new Runnable() {
			public void run() {
				poe.printOdd();
			}
		});

		T1.start();
		T2.start();

	}

}
