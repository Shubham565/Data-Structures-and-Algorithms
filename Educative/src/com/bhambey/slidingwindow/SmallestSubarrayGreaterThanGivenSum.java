package com.bhambey.slidingwindow;

/*
 * PROBLEM STATEMENT:
 * Given an array of positive integers and a number ‘S,’ 
 * find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. 
 * Return 0 if no such subarray exists.
 * 
 * TC: O(N+N) ~ O(N)
 * SC: O(1)
 * */

public class SmallestSubarrayGreaterThanGivenSum {

	public static void main(String[] args) {

		int result = SmallestSubarrayGreaterThanGivenSum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
		System.out.println("Smallest subarray length: " + result);
		result = SmallestSubarrayGreaterThanGivenSum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
		System.out.println("Smallest subarray length: " + result);
		result = SmallestSubarrayGreaterThanGivenSum.findMinSubArray(8, new int[] { 2, 1, 5, 2, 3, 2 });
		System.out.println("Smallest subarray length: " + result);

	}

	private static int findMinSubArray(int s, int[] arr) {
		int n = arr.length;

		int lengthOfSmallestSubarray = Integer.MAX_VALUE;
		int windowSum = 0;

		int windowStart = 0;
		for (int windowEnd = windowStart; windowEnd < n; windowEnd++) {
			windowSum += arr[windowEnd]; // Add the next element to the window

			while (windowSum >= s) { // Shrink the window as small as possible until the 'windowSum' is smaller than
										// 'K'
				lengthOfSmallestSubarray = Math.min(lengthOfSmallestSubarray, windowEnd - windowStart + 1);
				windowSum -= arr[windowStart]; // Discard the element at 'windowStart' since it is going out of the
												// window
				windowStart++; // Shrink the window
			}
		}

		return lengthOfSmallestSubarray == Integer.MAX_VALUE ? 0 : lengthOfSmallestSubarray;
	}

}
