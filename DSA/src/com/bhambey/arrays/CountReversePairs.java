package com.bhambey.arrays;

public class CountReversePairs {

	public static void main(String[] args) {
		int[] a = { 4, 1, 2, 3, 1 };
		int n = 5;
		int cnt = ArrayUtil.countReversePairs(a, n);
		System.out.println("The number of reverse pair is: " + cnt);
	}

}
