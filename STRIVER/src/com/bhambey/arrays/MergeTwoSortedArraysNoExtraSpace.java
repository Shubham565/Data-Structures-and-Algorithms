package com.bhambey.arrays;

public class MergeTwoSortedArraysNoExtraSpace {

	public static void main(String[] args) {

		long[] arr1 = { 1, 4, 8, 10 };
		long[] arr2 = { 2, 3, 9 };
		int n = 4, m = 3;
		ArrayUtil.mergeTwoSortedArraysNoExtraSpace(arr1, arr2, n, m);
		System.out.println("The merged arrays are:");
		System.out.print("arr1[] = ");
		for (int i = 0; i < n; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.print("\narr2[] = ");
		for (int i = 0; i < m; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println();
	}

}
