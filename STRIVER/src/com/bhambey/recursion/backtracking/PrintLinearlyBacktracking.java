package com.bhambey.recursion.backtracking;

public class PrintLinearlyBacktracking {

	public static void main(String[] args) {

		int n = 5;
		int i = n;
		printBacktracking(n, i);

	}

	public static void printBacktracking(int n, int i) {

		if (i < 1)
			return;

		printBacktracking(n, i - 1);

		System.out.print(i + " ");

	}

}
