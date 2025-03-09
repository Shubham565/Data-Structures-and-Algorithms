package com.bhambey.dynamic;

import java.util.Arrays;

// LeetCode 70
public class ClimbingStairs {

	public static void main(String[] args) {

		int n = 5;
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		System.out.println(solveRec(n));
		System.out.println(solveTab(n));
		System.out.println(solveMem(n, dp));
		System.out.println(solveReduce(n));

	}

	private static int solveRec(int n) {

		if (n == 0)
			return 1;

		if (n < 0)
			return 0;

		return solveRec(n - 1) + solveRec(n - 2);

	}

	private static int solveTab(int n) {

		int[] dp = new int[n];

		dp[0] = 1;
		dp[1] = 2;

		for (int i = 2; i < n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n - 1];
	}

	private static int solveMem(int n, int[] dp) {

		if (n < 0)
			return 0;
		if (dp[n] != -1)
			return dp[n];

		if (n == 0)
			return 1;

		return dp[n] = solveMem(n - 1, dp) + solveMem(n - 2, dp);
	}

	private static int solveReduce(int n) {

		int prev2 = 1, prev = 2;

		for (int i = 2; i < n; i++) {
			int curr = prev + prev2;
			prev2 = prev;
			prev = curr;
		}

		return prev;
	}

}
