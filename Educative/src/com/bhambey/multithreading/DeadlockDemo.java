package com.bhambey.multithreading;

public class DeadlockDemo {

	public static void main(String[] args) {
		Deadlock deadlock = new Deadlock();
		try {
			deadlock.runTest();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
