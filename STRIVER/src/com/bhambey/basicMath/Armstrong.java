package com.bhambey.basicMath;

public class Armstrong {

	public static void main(String[] args) {
		int n = 156;
		armstrong(n);
	}

	private static void armstrong(int n) {
		int originalno = n;
		int count = 0;
		int temp = n;
		while (temp != 0) {
			count++;
			temp = temp / 10;
		}
		int sumofpower = 0;
		while (n != 0) {
			int digit = n % 10;
			sumofpower += Math.pow(digit, count);
			n /= 10;
		}
		System.out.println(sumofpower == originalno);
	}

}
