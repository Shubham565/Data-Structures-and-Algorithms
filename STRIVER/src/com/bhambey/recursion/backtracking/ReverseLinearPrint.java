package com.bhambey.recursion.backtracking;

public class ReverseLinearPrint {

	public static void main(String[] args) {

		int n = 5;
		printReverse(n, 1);

	}

	public static void printReverse(int n, int i) {

		if (n < i)
			return;

		System.out.print(n + " ");
		printReverse(n - 1, i);

	}

}
