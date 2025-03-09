package com.bhambey.dynamic;

import java.util.Arrays;

public class Fibonacci {

	public static void main(String[] args) {

		int n = 6;
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		System.out.println(fibReduce(n));

	}

	// Memoization
	private static int fibMem(int n, int[] dp) {

		if (n <= 1)
			return n;

		if (dp[n] != -1)
			return dp[n];

		return dp[n] = fibMem(n - 2, dp) + fibMem(n - 1, dp);
	}

	// Tabulation
	private static int fibTab(int n, int[] dp) {

		if (n < 2)
			return n;

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i < n; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}

		return dp[n - 1];
	}

	// Reducing SC
	private static int fibReduce(int n) {

		int prev2 = 0;
		int prev1 = 1;
		for (int i = 2; i <= n; i++) {
			int curi = prev2 + prev1;
			prev2 = prev1;
			prev1 = curi;
		}
		return prev1;
	}

}
