package com.bhambey.slidingwindow;

/*
 * PROBLEM STATEMENT:
 * Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.
 * 
 * TC: O(N)
 * SC: O(1)
 * 
 * */

public class MaximumSumSubarray {

	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 1, 3, 2 };
		int k = 3;
		int sum = maxSumSubarray(arr, k);

		System.out.println("Required sum: " + sum);
	}

	private static int maxSumSubarray(int[] arr, int k) {

		/*
		 * int sum = 0, max = 0;
		 * 
		 * for (int i = 0; i < arr.length - k; i++) { sum = 0; for (int j = i; j < i +
		 * k; j++) { sum += arr[j]; } max = Math.max(max, sum); }
		 * 
		 * return max;
		 */

		int winSum = 0, maxSum = 0;
		int winStart = 0;

		for (int winEnd = 0; winEnd < arr.length; winEnd++) {
			winSum += arr[winEnd];
			if (winEnd >= k - 1) {
				maxSum = Math.max(winSum, maxSum);
				winSum -= arr[winStart];
				winStart++;
			}

		}
		return maxSum;
	}

}
