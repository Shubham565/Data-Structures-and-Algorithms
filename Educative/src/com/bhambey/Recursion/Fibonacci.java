package com.bhambey.Recursion;

public class Fibonacci {

	public static void main(String[] args) {
		int input = 5;
		System.out.println("Fibonacci sequence for the first " + input + " elements is:");

		int i = 0;
		while (i < input) {
			System.out.print(RecursionUtil.fibonacci(i) + " ");
			i++;
		}
	}

}
