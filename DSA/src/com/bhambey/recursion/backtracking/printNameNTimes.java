package com.bhambey.recursion.backtracking;

public class printNameNTimes {

	public static void main(String[] args) {

		printName(3);

	}

	private static void printName(int n) {

		if (n < 1)
			return;

		System.out.println("Shubham");

		printName(n - 1);

	}

}
