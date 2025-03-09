package com.bhambey.Recursion;

public class NumberOfOccurenceArray {

	public static void main(String[] args) {

		System.out.print("{");

		int[] array = { 2, 3, 4, 1, 7, 8, 3 };
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

		System.out.println("}");

		int key = 3;
		int output = RecursionUtil.numberOfOccurenceArray(array, key, 0);
		System.out.println("Number of occurrences of " + key + ": " + output);

	}

}
