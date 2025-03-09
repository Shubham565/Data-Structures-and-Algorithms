package com.bhambey.recursion.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetSumOne {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 1 };
		ArrayList<Integer> list = new ArrayList<>();
		func(0, 0, arr, arr.length, list);
		Collections.sort(list);
		for (Integer i : list) {
			System.out.println(i);
		}

	}

	private static void func(int i, int sum, int[] arr, int n, ArrayList<Integer> list) {

		if (i == n) {
			list.add(sum);
			return;
		}

		func(i + 1, sum + arr[i], arr, n, list);

		func(i + 1, sum, arr, n, list);

	}

}
