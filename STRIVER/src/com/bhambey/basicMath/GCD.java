package com.bhambey.basicMath;

public class GCD {
	public static void main(String[] args) {
		int a = 3;
		int b = 6;
		System.out.println("GCD or given numbers: " + findGCDEuclidean(a, b));

	}

	private static void findGCD(int a, int b) {

		int ans = 1;

		for (int i = 1; i <= Math.min(a, b); i++) {
			if (a % i == 0 && b % i == 0)
				ans = i;
		}

		System.out.println("GCD for given numbers: " + ans);
	}

	private static int findGCDEuclidean(int a, int b) {

		if (b == 0) {
			return a;
		}
		return findGCDEuclidean(b, a % b);

	}
}
