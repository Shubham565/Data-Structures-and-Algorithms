package com.bhambey.basicMath;

public class primeNumber {
	public static void main(String[] args) {

		int n = 12;
		boolean isPrime = isPrime(n);
		if (isPrime == true) {
			System.out.println("This is a prime number");
		} else {
			System.out.println("This is not a prime number");
		}
	}

	private static boolean isPrime(int n) {
		boolean flag = true;
		for (int i = 1; i < Math.sqrt(n); i++) {
			if (n % i == 0) {
				flag = false;
			} else {
				flag = true;
			}
		}
		return flag;
	}
}
