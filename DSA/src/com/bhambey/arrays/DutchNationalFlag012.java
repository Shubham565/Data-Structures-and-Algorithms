package com.bhambey.arrays;

public class DutchNationalFlag012 {

	public static void main(String[] args) {

		int[] arr = { 0, 2, 1, 2, 0, 1, 2, 0, 2, 0, 0, 0, 1, 1, 2, 1, 2, 0, 0, 2, 2, 1 };
		ArrayUtil.dutchNationalFlag(arr);
		System.out.println("AFTER SORTING: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
