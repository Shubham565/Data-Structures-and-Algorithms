package com.bhambey.arrays;

public class MaxSubarraySum {

	public static void main(String[] args) {

		int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int n = arr.length;
		long maxSum = ArrayUtil.maxSubarraySum(arr, n);
		System.out.println("The maximum subarray sum is: " + maxSum);

	}

}
