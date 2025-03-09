package com.bhambey.basicMath;

public class CountDigits {

	public static void main(String[] args) {
		int n = 345768567;
		// countDigitsLoop(n);
		// countDigitsStringLength(n);
		countDigitsLog(n);

	}

	private static void countDigitsLog(int n) {

		int digits = (int) Math.floor(Math.log10(n) + 1);
		System.out.println(digits);

	}

	private static void countDigitsStringLength(int n) {
		String num = Integer.toString(n);
		System.out.println(num.length());

	}

	private static void countDigitsLoop(int n) {

		int count = 0;

		while (n > 0) {
			n /= 10;
			count++;
		}

		System.out.println(count);

	}

}
