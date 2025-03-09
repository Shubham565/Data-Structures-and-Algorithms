package com.bhambey.patterns;

public class Pattern12 {

	public static void main(String[] args) {
		int n = 5;
		printPattern(n);
	}

	private static void printPattern(int n) {

		int num = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(num + " ");
				num += 1;
			}
			System.out.println();
		}

	}

}
