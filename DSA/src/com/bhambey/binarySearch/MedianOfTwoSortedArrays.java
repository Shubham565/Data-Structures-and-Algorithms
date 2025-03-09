package com.bhambey.binarySearch;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		int[] a = { 1, 4, 7, 10, 12 };
		int[] b = { 2, 3, 6, 15 };
		System.out.println("The median of two sorted arrays is " + BinarySearchUtil.medianOfTwoSortedArrays(a, b));
	}
}
