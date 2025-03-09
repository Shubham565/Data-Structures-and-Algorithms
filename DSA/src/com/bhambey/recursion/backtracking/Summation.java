package com.bhambey.recursion.backtracking;

public class Summation {

	public static void main(String[] args) {

		int n = 5;
		System.out.println(sumNumber(n));

	}

	private static int sumNumber(int n) {

		if (n == 0)
			return 0;

		return n + sumNumber(n - 1);

	}

}
