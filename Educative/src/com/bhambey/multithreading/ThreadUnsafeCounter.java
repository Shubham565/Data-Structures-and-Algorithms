package com.bhambey.multithreading;

public class ThreadUnsafeCounter {

	int counter = 0;
	
	public void increment()
	{
		counter++;
	}
	
	public void decrement()
	{
		counter--;
	}
	
	public void printFinalCounterValue ()
	{
		System.out.println("Final value of counter: " + counter);
	}
	
}
