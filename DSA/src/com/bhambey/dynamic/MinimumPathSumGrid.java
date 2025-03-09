package com.bhambey.dynamic;

import java.util.Arrays;

/*
 * 
 * Problem Description: 
 * We are given an “N*M” matrix of integers. 
 * We need to find a path from the top-left corner to the bottom-right corner of the matrix, such that there is a minimum cost past that we select.
 * At every cell, we can move in only two directions: right and bottom. The cost of a path is given as the sum of values of cells of the given matrix.
 * 
 * */

public class MinimumPathSumGrid {

	public static void main(String[] args) {

		int[][] grid = { { 5, 9, 6 }, { 11, 5, 2 } };

		int m = grid.length;
		int n = grid[0].length;

		System.out.println(minSumPathRec(m - 1, n - 1, grid));
		System.out.println(minSumPathMem(m, n, grid));
		System.out.println(minSumPathTab(m, n, grid));
		System.out.println(minSumPathReduce(m, n, grid));

	}

	// RECURSIVE
	// TC: O(m*n)
	// SC: O((m-1)*(n-1))
	private static int minSumPathRec(int m, int n, int[][] grid) {

		if (m == 0 && n == 0)
			return grid[0][0];

		if (m < 0 || n < 0)
			return (int) Math.pow(10, 9);

		int up = grid[m][n] + minSumPathRec(m - 1, n, grid);
		int left = grid[m][n] + minSumPathRec(m, n - 1, grid);

		return Math.min(up, left);
	}

	// MEMOIZATION
	// TC:O(m*n)
	// SC:O((m-1)+(n-1)) + O(m*n)
	private static int minSumPathMem(int m, int n, int[][] grid) {
		int[][] dp = new int[m][n];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return solveMem(m - 1, n - 1, grid, dp);

	}

	private static int solveMem(int m, int n, int[][] grid, int[][] dp) {

		if (m == 0 && n == 0)
			return grid[0][0];

		if (m < 0 || n < 0)
			return (int) Math.pow(10, 9);

		if (dp[m][n] != -1)
			return dp[m][n];

		int up = grid[m][n] + minSumPathRec(m - 1, n, grid);
		int left = grid[m][n] + minSumPathRec(m, n - 1, grid);

		return dp[m][n] = Math.min(up, left);

	}

	// TABULATION
	// TC: O(m*n)
	// SC: O(m*n)
	private static int minSumPathTab(int m, int n, int[][] grid) {
		int[][] dp = new int[m][n];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return solveTab(m, n, grid, dp);

	}

	private static int solveTab(int m, int n, int[][] grid, int[][] dp) {

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0)
					dp[i][j] = grid[i][j];
				else {
					int up = grid[i][j];
					if (i > 0)
						// Requiring previous row's j column
						up += dp[i - 1][j];
					else
						up += Math.pow(10, 9);

					int left = grid[i][j];
					if (j > 0)
						// Requiring current row's j-1 column
						left += dp[i][j - 1];
					else
						left += Math.pow(10, 9);

					dp[i][j] = Math.min(up, left);
				}

			}
		}
		return dp[m - 1][n - 1];
	}

	// SPACE OPTIMIZATION
	// TC: O(m*n)
	// SC: O(n)

	private static int minSumPathReduce(int m, int n, int[][] grid) {

		int[] prev = new int[n];
		for (int i = 0; i < m; i++) {
			int[] temp = new int[n];
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0)
					temp[j] = grid[i][j];
				else {
					int up = grid[i][j];
					if (i > 0)
						// Requiring previous row's j column
						up += prev[j];
					else
						up += Math.pow(10, 9);

					int left = grid[i][j];
					if (j > 0)
						// Requiring current row's j-1 column
						left += temp[j - 1];
					else
						left += Math.pow(10, 9);

					temp[j] = Math.min(up, left);
				}

			}
			prev = temp;
		}
		return prev[n - 1];
	}

}
