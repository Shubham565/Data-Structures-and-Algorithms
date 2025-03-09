package com.bhambey.binarySearch;

import java.util.*;

public class PeakElement {

	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 1, 3, 5, 6, 4));
		int ans = BinarySearchUtil.findPeakElement(arr);
		System.out.println("The peak is at index: " + ans);
	}

}
