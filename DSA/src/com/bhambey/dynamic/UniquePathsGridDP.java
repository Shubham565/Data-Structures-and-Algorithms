package com.bhambey.dynamic;

import java.util.Arrays;

/*
 * PROBLEM STATEMENT
You are present at point ‘A’ which is the top-left cell of an M X N matrix, your destination is point ‘B’, which is the bottom-right cell of the same matrix. 
Your task is to find the total number of unique paths from point ‘A’ to point ‘B’.
In other words, you will be given the dimensions of the matrix as integers ‘M’ and ‘N’, 
your task is to find the total number of unique paths from the cell MATRIX[0][0] to MATRIX['M' - 1]['N' - 1].

To traverse in the matrix, you can either move Right or Down at each step. For example in a given point MATRIX[i] [j],
you can move to either MATRIX[i + 1][j] or MATRIX[i][j + 1].

Input Format:
The first line of input contains an integer 'T' representing the number of the test case. 

The first and the only line of each test case contains two space-separated integers ‘M’ and ‘N’,
denoting the number of rows and number of columns of the matrix respectively. 
Output Format:
For every test case, return a single integer, which is the total number of unique paths for traveling from top-left to bottom-right cells of the matrix.

The output of each test case is printed in a separate line.
Note:
You don’t have to print anything, it has already been taken care of. Just implement the given function. 
Constraints:
1 ≤ T ≤ 100
1 ≤ M ≤ 15
1 ≤ N ≤ 15

Where ‘M’ is the number of rows and ‘N’ is the number of columns in the matrix. 

Time limit: 1 sec

 * */

public class UniquePathsGridDP {

	public static void main(String[] args) {
		int m = 3;
		int n = 3;

		System.out.println(countPathsRec(m, n));
		System.out.println(countPathsMem(m, n));
		System.out.println(countPathsTab(m, n));
		System.out.println(countPathsReduce(m, n));
	}

	private static int countPathsRec(int i, int j) {

		return solveRec(i - 1, j - 1);
	}

	private static int solveRec(int i, int j) {
		if (i == 0 && j == 0) {
			return 1;
		}

		if (i < 0 || j < 0) {
			return 0;
		}

		int up = solveRec(i - 1, j);
		int left = solveRec(i, j - 1);

		return up + left;

	}

	// MEMOIZATION
	// TC: O(m*n)
	// SC: O((m-1) + (n-1)) + O(m*n)
	private static int countPathsMem(int m, int n) {

		int[][] dp = new int[m][n];

		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return solveMem(m - 1, n - 1, dp);
	}

	private static int solveMem(int i, int j, int[][] dp) {

		if (i == 0 && j == 0) {
			return 1;
		}

		if (i < 0 || j < 0)
			return 0;

		if (dp[i][j] != -1)
			return dp[i][j];

		int up = solveMem(i - 1, j, dp);
		int left = solveMem(i, j - 1, dp);

		return dp[i][j] = up + left;
	}

	// TABULATION
	// TC: O()
	// SC: O()
	private static int countPathsTab(int m, int n) {

		int[][] dp = new int[m][n];

		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return solveTab(m, n, dp);
	}

	private static int solveTab(int m, int n, int[][] dp) {

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = 1;
					continue;
				}

				int up = 0;
				int left = 0;

				if (i > 0) {
					up = dp[i - 1][j];
				}
				if (j > 0) {
					left = dp[i][j - 1];
				}

				dp[i][j] = up + left;

			}
		}

		return dp[m - 1][n - 1];

	}

	// SPACE OPTIMIZATION
	// TC: O(m*n)
	// SC: O(n)
	private static int countPathsReduce(int m, int n) {

		int[] prev = new int[n];

		for (int i = 0; i < m; i++) {
			int[] temp = new int[n];
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					temp[j] = 1;
					continue;
				}

				int up = 0;
				int left = 0;

				if (i > 0) {
					up = prev[j];
				}
				if (j > 0) {
					left = temp[j - 1];
				}

				temp[j] = up + left;

			}
			prev = temp;
		}

		return prev[n - 1];
	}

}
