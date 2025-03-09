package com.bhambey.dynamic;

import java.util.ArrayList;
import java.util.List;

// TC: O(N)
// SC: O(1)

public class HouseRobber {
	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(5);
		list.add(1);
		list.add(2);
		list.add(6);

		int n = list.size();

		System.out.println(robStreet(n, list));

	}

	private static long robStreet(int n, List<Integer> list) {

		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();

		if (n == 1)
			return list.get(0);

		for (int i = 0; i < n; i++) {
			if (i != 0)
				list1.add(list.get(i));
			if (i != n - 1)
				list2.add(list.get(i));

		}

		long ans1 = solve(list1);
		long ans2 = solve(list2);

		return Math.max(ans1, ans2);

	}

	private static long solve(List<Integer> list) {

		int n = list.size();
		long prev = list.get(0);
		long prev2 = 0;

		for (int i = 1; i < list.size(); i++) {

			long pick = list.get(i);
			if (i > 1) {
				pick += prev2;
			}
			long notPick = prev;

			long curr = Math.max(pick, notPick);
			prev2 = prev;
			prev = curr;
		}

		return prev;
	}

}
