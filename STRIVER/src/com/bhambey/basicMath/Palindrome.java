package com.bhambey.basicMath;

public class Palindrome {

	public static void main(String[] args) {
		int n = 12321;
		palindrome(n);
	}

	private static void palindrome(int n) {

		int num = 0;

		while (n > 0) {
			int temp = n % 10;
			num = num * 10 + temp;
			n /= 10;
		}

		if (n == num) {
			System.out.println("Palindrome");
		} else {
			System.out.println("Not Palindrome");
		}

	}

}
