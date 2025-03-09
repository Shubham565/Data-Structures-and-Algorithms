package com.bhambey.dynamic;

import java.util.Arrays;

public class MaximumSumNonAdjacentElements {

	public static void main(String[] args) {
		int arr[] = { 2, 1, 4, 9 };
		int n = arr.length - 1;
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		System.out.println(solveRec(arr, n));
		System.out.println(solveMem(n, arr, dp));
		System.out.println(solveTab(n, arr, dp));
		System.out.println(solveReduce(n, arr));
	}

	// TC: O(N)
	// SC: O(N)
	private static int solveRec(int[] arr, int ind) {

		if (ind == 0)
			return arr[ind];

		if (ind < 0)
			return 0;

		int pick = arr[ind] + solveRec(arr, ind - 2);
		int notPick = solveRec(arr, ind - 1);

		return Math.max(pick, notPick);

	}

	// TC: O(N)
	// SC: O(N)
	private static int solveMem(int ind, int[] arr, int[] dp) {

		if (ind == 0)
			return arr[ind];

		if (ind < 0)
			return 0;

		if (dp[ind] != -1)
			return dp[ind];

		int pick = arr[ind] + solveMem(ind - 2, arr, dp);
		int notPick = solveMem(ind - 1, arr, dp);

		return dp[ind] = Math.max(pick, notPick);
	}

	// TC: O(N)
	// SC: O(N)
	private static int solveTab(int ind, int[] arr, int[] dp) {

		dp[0] = 0;

		for (int i = 1; i < ind; i++) {
			int pick = arr[i];
			if (i > 1) {
				pick += dp[i - 2];
			}
			int notPick = dp[i - 1];

			dp[i] = Math.max(pick, notPick);
		}

		return dp[ind];
	}

	// TC: O(N)
	// SC: O(1)
	private static int solveReduce(int ind, int[] arr) {

		int prev = arr[0];
		int prev2 = 0;

		for (int i = 1; i <= ind; i++) {
			int pick = arr[i];
			if (i > 1) {
				pick += prev2;
			}
			int notPick = prev;

			int curr = Math.max(pick, notPick);
			prev2 = prev;
			prev = curr;

		}

		return prev;
	}

}
