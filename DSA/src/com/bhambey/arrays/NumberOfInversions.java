package com.bhambey.arrays;

public class NumberOfInversions {

	public static void main(String[] args) {
		int[] a = { 5, 4, 3, 2, 1 };
		int n = 5;
		int cnt = ArrayUtil.numberOfInversions(a, n);
		System.out.println("The number of inversions are: " + cnt);
	}
}
