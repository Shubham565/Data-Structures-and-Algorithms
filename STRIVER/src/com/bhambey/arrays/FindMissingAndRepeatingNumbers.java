package com.bhambey.arrays;

public class FindMissingAndRepeatingNumbers {

	public static void main(String[] args) {
		int[] a = { 3, 1, 2, 5, 4, 6, 7, 5 };
		int[] ans = ArrayUtil.findMissingAndRepeatingNumbers(a);
		System.out.println("The repeating and missing numbers are: {" + ans[0] + ", " + ans[1] + "}");
	}

}
