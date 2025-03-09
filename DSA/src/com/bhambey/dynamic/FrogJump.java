package com.bhambey.dynamic;

import java.util.Arrays;

/*
 * 
PROBLEM STATEMENT
There is a frog on the 1st step of an N stairs long staircase. 
The frog wants to reach the Nth stair. HEIGHT[i] is the height of the (i+1)th stair.If Frog jumps from ith to jth stair, 
the energy lost in the jump is given by |HEIGHT[i-1] - HEIGHT[j-1].
In the Frog is on ith staircase, he can jump either to (i+1)th stair or to (i+2)th stair
Your task is to find the minimum total energy used by the frog to reach from 1st stair to Nth stair.

For Example
If the given ‘HEIGHT’ array is [10,20,30,10], the answer 20 as the frog can jump from 1st stair to 2nd stair
(|20-10| = 10 energy lost) and then a jump from 2nd stair to last stair (|10-20| = 10 energy lost).
So, the total energy lost is 20.
Input Format:
The first line of the input contains an integer, 'T,’ denoting the number of test cases.

The first line of each test case contains a single integer,' N’, denoting the number of stairs in the staircase,

The next line contains ‘HEIGHT’ array.
Output Format:
For each test case, return an integer corresponding to the minimum energy lost to reach the last stair.
Note:
You do not need to print anything. It has already been taken care of. Just implement the given function.
Constraints:
1 <= T <= 10
1 <= N <= 100000.
1 <= HEIGHTS[i] <= 1000 .

Time limit: 1 sec
 * 
 * */

public class FrogJump {

	public static void main(String[] args) {

		int h[] = { 30, 10, 60, 10, 60, 50 };
		int n = h.length;
		int[] dp = new int[n];
		Arrays.fill(dp, -1);
		System.out.println(solveRec(n - 1, h));
		System.out.println(solveMem(n - 1, h, dp));
		System.out.println(solveTab(n - 1, h, dp));
		System.out.println(solveReduce(n - 1, h, dp));

	}

	private static int solveRec(int ind, int[] h) {

		if (ind == 0)
			return 0;

		int left = solveRec(ind - 1, h) + Math.abs(h[ind] - h[ind - 1]);
		int right = Integer.MAX_VALUE;
		if (ind > 1)
			right = solveRec(ind - 2, h) + Math.abs(h[ind] - h[ind - 2]);

		return Math.min(left, right);
	}

	private static int solveMem(int ind, int[] h, int[] dp) {

		if (ind == 0)
			return 0;

		if (dp[ind] != -1) {
			return dp[ind];
		}

		int left = solveMem(ind - 1, h, dp) + Math.abs(h[ind] - h[ind - 1]);
		int right = Integer.MAX_VALUE;
		if (ind > 1) {
			right = solveMem(ind - 2, h, dp) + Math.abs(h[ind] - h[ind - 2]);
		}

		return dp[ind] = Math.min(left, right);
	}

	private static int solveTab(int ind, int[] h, int[] dp) {

		dp[0] = 0;

		for (int i = 1; i <= ind; i++) {
			int right = Integer.MAX_VALUE;
			int left = dp[i - 1] + Math.abs(h[i] - h[i - 1]);
			if (i > 1) {
				right = dp[i - 2] + Math.abs(h[i] - h[i - 2]);
			}
			dp[i] = Math.min(left, right);
		}

		return dp[ind];
	}

	private static int solveReduce(int ind, int[] h, int[] dp) {

		int prev = 0;
		int prev2 = 0;

		for (int i = 1; i < ind; i++) {

			int left = prev + Math.abs(h[ind] - h[ind - 1]);
			int right = Integer.MAX_VALUE;
			if (i > 1)
				right = prev2 + Math.abs(h[ind] - h[ind - 2]);

			int curr = Math.min(left, right);
			prev2 = prev;
			prev = curr;
		}

		return prev;

	}

}
