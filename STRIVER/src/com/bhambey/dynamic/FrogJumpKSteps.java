package com.bhambey.dynamic;

import java.util.Arrays;

/*
 * 
 * This is a follow-up question to “Frog Jump”. 
 * In the previous question, the frog was allowed to jump either one or two steps at a time.
 * In this question, the frog is allowed to jump up to ‘K’ steps at a time. If K=4, the frog can jump 1,2,3, or 4 steps at every index.
 * 
 * */

public class FrogJumpKSteps {

	public static void main(String[] args) {

		int[] h = { 30, 10, 60, 10, 60, 50 };
		int n = h.length - 1;
		int k = 3;

		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);

		System.out.println(solveRec(n, k, h));
		System.out.println(solveMem(n, k, h, dp));
		System.out.println(solveTab(n, k, h, dp));

	}

	private static int solveRec(int ind, int k, int[] h) {

		if (ind == 0)
			return 0;

		int minSteps = Integer.MAX_VALUE;
		for (int i = 1; i <= k; i++) {
			if ((ind - i) >= 0) {
				int jump = solveRec(ind - i, k, h) + Math.abs(h[ind] - h[ind - i]);
				minSteps = Math.min(jump, minSteps);
			}
		}

		return minSteps;
	}

	// TC: O(N*K)
	// SC: O(N)
	private static int solveMem(int ind, int k, int[] h, int[] dp) {

		if (ind == 0)
			return 0;

		if (dp[ind] != -1)
			return dp[ind];

		int minSteps = Integer.MAX_VALUE;

		for (int i = 1; i <= k; i++) {
			if (ind - i >= 0) {
				int jump = solveMem(ind - i, k, h, dp) + Math.abs(h[ind] - h[ind - i]);
				minSteps = Math.min(jump, minSteps);
			}
		}

		return dp[ind] = minSteps;
	}

	// TC: O(N*K)
	// SC: O(N)
	private static int solveTab(int ind, int k, int[] h, int[] dp) {

		dp[0] = 0;

		for (int i = 1; i < ind; i++) {
			int minSteps = Integer.MAX_VALUE;
			for (int j = 1; j <= k; j++) {
				if (i - j >= 0) {
					int jump = dp[i - j] + Math.abs(h[i] - h[i - j]);
					minSteps = Math.min(jump, minSteps);
				}
			}
			dp[i] = minSteps;
		}

		return dp[ind];
	}

}
