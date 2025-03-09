package com.bhambey.patterns;

public class Pattern15 {

	public static void main(String[] args) {
		int n = 5;
		printPattern(n);
	}

	private static void printPattern(int n) {
		char ch = 'A';
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(ch + " ");
			}
			ch += 1;
			System.out.println();
		}

	}

}
