package com.bhambey.basicMath;

public class PrintAllDivisors {

	public static void main(String[] args) {
		int n = 8;
		printDivisorsBrute(n);
		printDivisorsSqrt(n);
	}

	private static void printDivisorsSqrt(int n) {

		System.out.println("The divisors of " + n + " are:");
		for (int i = 1; i <= (int) Math.sqrt(n); i++)
			if (n % i == 0) {
				System.out.print(i + " ");
				if (i != n / i)
					System.out.print(n / i + " ");
			}

		System.out.println();
	}

	private static void printDivisorsBrute(int n) {

		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0) {
				System.out.println(i);
			}
		}
	}
}
