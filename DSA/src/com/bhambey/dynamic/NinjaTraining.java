package com.bhambey.dynamic;

import java.util.Arrays;

/*
 * 
 * 
PROBLEM STATEMENT
Ninja is planning this ‘N’ days-long training schedule. Each day, he can perform any one of these three activities. 
(Running, Fighting Practice or Learning New Moves). Each activity has some merit points on each day. 
As Ninja has to improve all his skills, he can’t do the same activity in two consecutive days. 
Can you help Ninja find out the maximum merit points Ninja can earn?

You are given a 2D array of size N*3 ‘POINTS’ with the points corresponding to each day and activity. 
Your task is to calculate the maximum number of merit points that Ninja can earn.

For Example
If the given ‘POINTS’ array is [[1,2,5], [3 ,1 ,1] ,[3,3,3] ],the answer will be 11 as 5 + 3 + 3.
Input Format:
The first line of the input contains an integer, 'T,’ denoting the number of test cases.

The first line of each test case contains a single integer,' N’, denoting the number of days.

The next ‘N’ lines of each test case have 3 integers corresponding to POINTS[i].
Output Format:
For each test case, return an integer corresponding to the maximum coins  Ninja can collect.
Note:
You do not need to print anything. It has already been taken care of. Just implement the given function.
Constraints:
1 <= T <= 10
1 <= N <= 100000.
1 <= values of POINTS arrays <= 100 .

Time limit: 1 sec
 * 
 * */

public class NinjaTraining {

	public static void main(String[] args) {

		int[][] points = { { 10, 40, 70 }, { 20, 50, 80 }, { 30, 60, 90 } };
		int n = points.length;
		System.out.println(ninjaTrainingRec(n, points));
		System.out.println(ninjaTrainingMem(n, points));
		System.out.println(ninjaTrainingTab(n, points));
		System.out.println(ninjaTrainingReduce(n, points));

	}

	// RECURSIVE
	// TC: O(N)
	// SC: O(N)

	private static int ninjaTrainingRec(int n, int[][] points) {

		return solveRec(n - 1, 3, points);
	}

	private static int solveRec(int day, int last, int[][] points) {

		if (day == 0) {
			int maxi = 0;
			for (int i = 0; i <= 2; i++) {
				if (i != last) {
					maxi = Math.max(maxi, points[0][i]);
				}
			}
			return maxi;
		}

		int maxi = 0;

		for (int i = 0; i <= 2; i++) {
			if (i != last) {
				int activity = points[day][i] + solveRec(day - 1, i, points);
				maxi = Math.max(maxi, activity);
			}
		}

		return maxi;
	}

	// MEMOIZATION
	// TC: O(N*4*3) ==> o(N)
	// SC: O(N)
	private static int ninjaTrainingMem(int n, int[][] points) {

		int[][] dp = new int[n][4];

		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return solveMem(n - 1, 3, points, dp);
	}

	private static int solveMem(int day, int last, int[][] points, int[][] dp) {

		if (dp[day][last] != -1)
			return dp[day][last];

		if (day == 0) {
			int maxi = 0;
			for (int i = 0; i <= 2; i++) {
				if (i != last) {
					maxi = Math.max(maxi, points[0][i]);
				}
			}
			return dp[day][last] = maxi;
		}

		int maxi = 0;

		for (int i = 0; i <= 2; i++) {
			if (i != last) {
				int activity = points[day][i] + solveMem(day - 1, i, points, dp);
				maxi = Math.max(maxi, activity);
			}
		}

		return dp[day][last] = maxi;
	}

	// TC: O(N*4*3) ==> O(N)
	// SC: O(N*4) ==> O(N)

	private static int ninjaTrainingTab(int n, int[][] points) {

		int[][] dp = new int[n][4];

		dp[0][0] = Math.max(points[0][1], points[0][2]);
		dp[0][1] = Math.max(points[0][0], points[0][2]);
		dp[0][2] = Math.max(points[0][0], points[0][1]);
		dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

		for (int day = 1; day < n; day++) {
			for (int last = 0; last < 4; last++) {
				dp[day][last] = 0;
				for (int task = 0; task <= 2; task++) {
					if (task != last) {
						dp[day][last] = Math.max(dp[day][last], points[day][task] + dp[day - 1][task]);
					}
				}
			}
		}

		return dp[n - 1][3];
	}

	// REDUCE SPACE COMPLEXITY
	// TC: O(N*4*3) ==> O(N)
	// SC: O(4) ==> O(1)

	private static int ninjaTrainingReduce(int n, int[][] points) {

		int[] prev = new int[4];

		prev[0] = Math.max(points[0][1], points[0][2]);
		prev[1] = Math.max(points[0][0], points[0][2]);
		prev[2] = Math.max(points[0][0], points[0][1]);
		prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

		for (int day = 1; day < n; day++) {
			int temp[] = new int[4];
			for (int last = 0; last < 4; last++) {
				temp[last] = 0;
				for (int task = 0; task <= 2; task++) {
					if (task != last) {
						temp[last] = Math.max(temp[last], points[day][task] + prev[task]);
					}
				}
			}
		}

		return prev[3];
	}

}
