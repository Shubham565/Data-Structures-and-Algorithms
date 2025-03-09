package com.bhambey.basicMath;

public class ReverseNumber {
	public static void main(String[] args) {
		int n = 7654321;
		reverseNumber(n);
	}

	private static void reverseNumber(int n) {

		int num = 0;

		while (n > 0) {
			int temp = n % 10;
			num = num * 10 + temp;
			n /= 10;
		}

		System.out.println(num);

	}
}
