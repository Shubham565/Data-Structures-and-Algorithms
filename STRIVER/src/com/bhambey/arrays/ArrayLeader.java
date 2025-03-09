package com.bhambey.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayLeader {

	public static void main(String[] args) {

		int n = 6;
		int arr[] = { 10, 22, 12, 3, 0, 6 };

		ArrayList<Integer> ans = ArrayUtil.printLeadersBruteForce(arr, n);

		Collections.sort(ans, Collections.reverseOrder());

		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}

	}

}
