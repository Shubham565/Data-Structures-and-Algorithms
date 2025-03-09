package com.bhambey.concurrency;

import java.util.LinkedList;

public class ProducerConsumer {

	public static void main(String[] args) throws InterruptedException {

		// Object of class having produce and consume methods
		final PC pc = new PC();

		// Creating producer thread
		Thread t1 = new Thread(new Runnable() {

			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		// Creating consumer thread
		Thread t2 = new Thread(new Runnable() {

			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		// Starting both threads
		t1.start();
		t2.start();

		// t1 finishes before t2
		t1.join();
		t2.join();

	}

	public static class PC {

		LinkedList<Integer> list = new LinkedList<>();
		int capacity = 2;

		public void produce() throws InterruptedException {
			int value = 0;
			while (true) {
				synchronized (this) {

					// Producer thread waits while the list is full
					while (list.size() == capacity) {
						wait();
					}
					System.out.println("Producer Produced: " + value);

					// To insert the jobs in the list
					list.add(value++);

					// Notifies the consumer thread that now it can start consuming
					notify();

					// Makes working of the program easier to understand
					Thread.sleep(value);

				}
			}
		}

		public void consume() throws InterruptedException {
			while (true) {
				synchronized (this) {

					// Consumer thread waits while the list is empty
					while (list.size() == 0) {
						wait();
					}

					// To retrieve the first entry in the list
					int val = list.removeFirst();

					System.out.println("Consumer consumed: " + val);

					// Wake up Producer thread
					notify();

					// Sleep
					Thread.sleep(1000);

				}
			}
		}

	}

}
