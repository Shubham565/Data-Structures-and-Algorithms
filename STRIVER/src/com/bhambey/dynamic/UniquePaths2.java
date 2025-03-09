package com.bhambey.dynamic;

import java.util.Arrays;

/*
 * PROBLEM STATEMENT
Given a ‘N’ * ’M’ maze with obstacles, count and return the number of unique paths to reach the right-bottom cell from the top-left cell.
A cell in the given maze has a value '-1' if it is a blockage or dead-end, else 0.
From a given cell, we are allowed to move to cells (i+1, j) and (i, j+1) only. Since the answer can be large, print it modulo 10^9 + 7.

For Example :
Consider the maze below :
0 0 0 
0 -1 0 
0 0 0

There are two ways to reach the bottom left corner - 

(1, 1) -> (1, 2) -> (1, 3) -> (2, 3) -> (3, 3)
(1, 1) -> (2, 1) -> (3, 1) -> (3, 2) -> (3, 3)

Hence the answer for the above test case is 2.
Input Format :
The first line contains a single integer ‘T’ denoting the number of test cases. Then each test case follows.

The first line of each test case contains integers ‘N’ and ‘M’ representing the size of the input grid.

Then ‘N’ lines follow, each of which contains ‘M’ space-separated integers denoting the elements of the matrix.
Output Format :
For each test case print an integer denoting the number of ways to reach the bottom right corner from the top-left corner modulo 10^9 + 7.

Output for each test case will be printed in a separate line.
Note :
You are not required to print anything; it has already been taken care of. Just implement the function.
Constraints :
1 <= T <= 10
1 <= N,M <= 200

Note: It is guaranteed that the top-left cell does not have an obstacle.

Time Limit: 1 sec
 * 
 * */

public class UniquePaths2 {

	public static void main(String[] args) {
		int[][] maze = { { 0, 0, 0 }, { 0, -1, 0 }, { 0, 0, 0 } };

		int m = maze.length;
		int n = maze[0].length;

		System.out.println(mazeObstaclesRec(m - 1, n - 1, maze));
		System.out.println(mazeObstaclesMem(m, n, maze));
		System.out.println(mazeObstaclesTab(m, n, maze));
		System.out.println(mazeObstaclesReduce(m, n, maze));
	}

	private static int mazeObstaclesRec(int m, int n, int[][] maze) {

		if (m == 0 && n == 0)
			return 1;

		if (m < 0 || n < 0)
			return 0;

		if (m > 0 && n > 0 && maze[m][n] == -1)
			return 0;

		int up = mazeObstaclesRec(m - 1, n, maze);
		int left = mazeObstaclesRec(m, n - 1, maze);

		return up + left;
	}

	// MEMOIZATION
	// TC: O(m*n)
	// SC: O((m-1)+(n-1)) + O(m*n)

	private static int mazeObstaclesMem(int m, int n, int[][] maze) {
		int[][] dp = new int[m][n];

		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return solveMem(m - 1, n - 1, maze, dp);

	}

	private static int solveMem(int m, int n, int[][] maze, int[][] dp) {

		if (m == 0 && n == 0)
			return 1;

		if (m < 0 || n < 0)
			return 0;

		if (m > 0 && n > 0 && maze[m][n] == -1)
			return 0;

		if (dp[m][n] != -1)
			return dp[m][n];

		int up = solveMem(m - 1, n, maze, dp);
		int left = solveMem(m, n - 1, maze, dp);

		return dp[m][n] = up + left;
	}

	// TABULATION
	// TC: O(M*N)
	// SC: O(M*N)
	private static int mazeObstaclesTab(int m, int n, int[][] maze) {
		int[][] dp = new int[m][n];

		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return solveTab(m, n, maze, dp);

	}

	private static int solveTab(int m, int n, int[][] maze, int[][] dp) {

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i > 0 && j > 0 && maze[i][j] == -1) {
					dp[i][j] = 0;
					continue;
				}

				if (i == 0 && j == 0) {
					dp[i][j] = 1;
					continue;
				}

				int up = 0;
				int left = 0;

				if (i > 0)
					up = dp[i - 1][j];
				if (j > 0)
					left = dp[i][j - 1];

				dp[i][j] = up + left;

			}
		}

		return dp[m - 1][n - 1];
	}

	// SPACE OPTIMIZED
	// TC: O(m*n)
	// SC: O(n)
	private static int mazeObstaclesReduce(int m, int n, int[][] maze) {

		int[] prev = new int[n];
		for (int i = 0; i < m; i++) {
			int[] temp = new int[n];
			for (int j = 0; j < n; j++) {

				if (i > 0 && j > 0 && maze[i][j] == -1) {
					temp[j] = 0;
					continue;
				}

				if (i == 0 && j == 0) {
					temp[j] = 1;
					continue;
				}

				int up = 0;
				int left = 0;

				if (i > 0)
					up = prev[j];
				if (j > 0)
					left = temp[j - 1];

				temp[j] = up + left;

			}
			prev = temp;
		}

		return prev[m - 1];
	}

}
