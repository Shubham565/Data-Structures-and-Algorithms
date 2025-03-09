package com.bhambey.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsequencesBitManipulation {

	public static void main(String[] args) {
		int[] arr = { 3, 1, 2 };
		List<List<Integer>> list = powerSet(arr);
		for (List<Integer> i : list) {
			System.out.print(i + " :: ");
		}
	}

	public static List<List<Integer>> powerSet(int[] c) {

		List<List<Integer>> ans = new ArrayList<>();
		int len = c.length;
		int total = 1 << len;

		for (int i = 0; i < total; i++) {
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < len; j++) {
				if ((i & (1 << j)) != 0) {
					list.add(c[j]);
				}
			}
			ans.add(new ArrayList<>(list));
		}
		return ans;
	}

}
