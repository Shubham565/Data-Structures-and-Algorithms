package com.bhambey.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsequencesRecursion {

	public static void main(String[] args) {
		int[] arr = { 3, 1, 2 };
		printSubsequence(arr, 0, new ArrayList<>());
	}

	public static void printSubsequence(int[] arr, int index, List<Integer> list) {

		if (index == arr.length) {
			System.out.print(list + " ");
			return;
		}

		list.add(arr[index]);
		printSubsequence(arr, index + 1, list);
		list.remove(list.size() - 1);
		printSubsequence(arr, index + 1, list);
	}

}
