package com.bhambey.Recursion;

public class FirstOccurenceInArray {

	public static void main(String[] args) {
		System.out.print("{");

		int[] array = { 2, 3, 4, 1, 7, 8, 3 };
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("}");

		int num = 3;

		int result = RecursionUtil.firstOccurrence(array, num, 0);
		System.out.println("The first occurrence of the number " + num + " is at index: " + result);
	}

}
