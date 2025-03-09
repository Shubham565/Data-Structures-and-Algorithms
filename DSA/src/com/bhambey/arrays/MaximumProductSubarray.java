package com.bhambey.arrays;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, -3, 0, -4, -5 };
		int answer = ArrayUtil.maximumProductSubarray(arr);
		System.out.println("The maximum product subarray is: " + answer);
	}

}
