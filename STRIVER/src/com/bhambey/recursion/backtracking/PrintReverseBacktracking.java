package com.bhambey.recursion.backtracking;

public class PrintReverseBacktracking {

	public static void main(String[] args) {

		int n = 5;
		int i = 1;
		reverseBacktracking(n, i);

	}

	public static void reverseBacktracking(int n, int i) {

		if (i > n)
			return;

		reverseBacktracking(n, i + 1);

		System.out.print(i + " ");

	}

}
