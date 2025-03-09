package com.bhambey.patterns;

public class Pattern18 {

	public static void main(String[] args) {
		int n = 4;
		printPattern(n);
	}

	private static void printPattern(int N) {

		int iniS = 0;
		for (int i = 0; i < N; i++) {

			for (int j = 1; j <= N - i; j++) {
				System.out.print("*");
			}

			for (int j = 0; j < iniS; j++) {
				System.out.print(" ");
			}

			for (int j = 1; j <= N - i; j++) {
				System.out.print("*");
			}

			iniS += 2;

			System.out.println();
		}

		iniS = 2 * N - 2;
		for (int i = 1; i <= N; i++) {

			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}

			for (int j = 0; j < iniS; j++) {
				System.out.print(" ");
			}

			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}

			iniS -= 2;

			System.out.println();
		}

	}

}
