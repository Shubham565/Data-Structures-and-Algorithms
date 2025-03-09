package com.bhambey.dynamic;

import java.util.Arrays;

/*
 * Problem Description: 
 * We are given a Triangular matrix. We need to find the minimum path sum from the first row to the last row.
 * At every cell we can move in only two directions: either to the bottom cell (↓) or to the bottom-right cell(↘)
 * */

public class Triangle {

	public static void main(String[] args) {
		int a[][] = { { 1 }, { 2, 3 }, { 3, 6, 7 }, { 8, 9, 6, 10 } };

		int n = a.length;

		System.out.println(minimumPathSumRec(a, n));
		System.out.println(minimumPathSumMem(a, n));
		System.out.println(minimumPathSumTab(a, n));
		System.out.println(minimumPathSumReduce(a, n));
	}

	// RECURSION
	// TC: O(n*n)
	// SC: O(1)
	private static int minimumPathSumRec(int[][] a, int n) {

		return solveRec(0, 0, a, n);

	}

	private static int solveRec(int i, int j, int[][] a, int n) {

		if (i == n - 1)
			return a[i][j];

		int d = a[i][j] + solveRec(i + 1, j, a, n);
		int dg = a[i][j] + solveRec(i + 1, j + 1, a, n);

		return Math.min(d, dg);

	}

	// MEMOIZATION
	// TC: O(n*n)
	// SC: O(n*n) + O(n)
	private static int minimumPathSumMem(int[][] a, int n) {

		int[][] dp = new int[n][n];

		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return solveMem(0, 0, a, n, dp);
	}

	private static int solveMem(int i, int j, int[][] a, int n, int[][] dp) {

		if (dp[i][j] != -1)
			return dp[i][j];

		if (i == n - 1)
			return a[i][j];

		int d = a[i][j] + solveMem(i + 1, j, a, n, dp);
		int dg = a[i][j] + solveMem(i + 1, j + 1, a, n, dp);

		return dp[i][j] = Math.min(d, dg);
	}

	// TABULATION
	// TC: O(n*n)
	// SC: O(n*n)
	private static int minimumPathSumTab(int[][] a, int n) {

		int[][] dp = new int[n][n];

		for (int j = 0; j < n; j++) {
			dp[n - 1][j] = a[n - 1][j];
		}

		for (int i = n - 2; i >= 0; i--) {
			for (int j = i; j >= 0; j--) {
				int down = a[i][j] + dp[i + 1][j];
				int diag = a[i][j] + dp[i + 1][j + 1];
				dp[i][j] = Math.min(down, diag);
			}
		}

		return dp[0][0];
	}

	// SPACE OPTIMIZATION
	// TC: O(n*n)
	// SC: O(n)
	private static int minimumPathSumReduce(int[][] a, int n) {

		int[] front = new int[n];
		int[] curr = new int[n];

		for (int j = 0; j < n; j++) {
			front[j] = a[n - 1][j];
		}

		for (int i = n - 2; i >= 0; i--) {
			for (int j = i; j >= 0; j--) {
				int down = a[i][j] + front[j];
				int diag = a[i][j] + front[j + 1];

				curr[j] = Math.min(down, diag);
			}
			front = curr;
		}

		return front[0];
	}

}
