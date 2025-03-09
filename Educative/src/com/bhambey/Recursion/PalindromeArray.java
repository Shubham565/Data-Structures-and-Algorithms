package com.bhambey.Recursion;

public class PalindromeArray {

	public static void main(String[] args) {

		int[] arr = { 1, 0, 0, 1 };
		System.out.println("The given array is palindrome: " + RecursionUtil.palindromeArray(arr, 0, arr.length - 1));

	}

}
