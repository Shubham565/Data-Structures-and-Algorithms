package com.bhambey.arrays;

public class LongestSubarrayForGivenSum {

	public static void main(String[] args) {
		int[] a = {2, 3, 5, 1, 9};
        long k = 8;
        int len = ArrayUtil.getLongestSubarrayForGivenSum(a, k);
        System.out.println("The length of the longest subarray is: " + len);

	}

}
