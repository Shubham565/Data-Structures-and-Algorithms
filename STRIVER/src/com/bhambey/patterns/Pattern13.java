package com.bhambey.patterns;

public class Pattern13 {

	public static void main(String[] args) {
		int n = 5;
		printPattern(n);
	}

	private static void printPattern(int n) {

		for (int i = 0; i <= n; i++) {
			for (char ch = 'A'; ch <= 'A' + i; ch++) {
				System.out.print(ch + " ");
			}
			System.out.println();
		}

	}

}
