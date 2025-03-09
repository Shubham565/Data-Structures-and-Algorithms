package com.bhambey.binarySearch;

import java.util.*;

public class PaintersPartition {

	public static void main(String[] args) {
		ArrayList<Integer> boards = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
		int k = 2;
		int ans = BinarySearchUtil.paintersPartition(boards, k);
		System.out.println("The answer is: " + ans);
	}

}
