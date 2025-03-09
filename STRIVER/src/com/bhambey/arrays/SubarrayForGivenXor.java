package com.bhambey.arrays;

public class SubarrayForGivenXor {

	public static void main(String[] args) {
		int[] a = { 4, 2, 2, 6, 4 };
		int k = 6;
		int ans = ArrayUtil.subarrayForGivenXor(a, k);
		System.out.println("The number of subarrays with XOR k is: " + ans);
	}

}
