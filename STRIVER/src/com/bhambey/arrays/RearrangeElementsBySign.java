package com.bhambey.arrays;

import java.util.*;

public class RearrangeElementsBySign {

	public static void main(String[] args) {

		int n = 6;
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, -4, -5, 3, 4));

		ArrayList<Integer> ans = ArrayUtil.RearrangebySign(A, n-1);

		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}

	}

}
