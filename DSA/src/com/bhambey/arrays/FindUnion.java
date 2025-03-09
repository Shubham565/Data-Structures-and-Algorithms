package com.bhambey.arrays;

import java.util.ArrayList;

public class FindUnion {

	public static void main(String[] args) {

		int n = 10, m = 7;
		int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int arr2[] = { 2, 3, 4, 4, 5, 11, 12 };
		ArrayList<Integer> Union = ArrayUtil.FindUnion(arr1, arr2, n, m);
		System.out.println("Union of arr1 and arr2 is ");
		for (int val : Union)
			System.out.print(val + " ");

	}

}
