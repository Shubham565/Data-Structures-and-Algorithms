package com.bhambey.binarySearch;

import java.util.*;

public class SingleNonDuplicate {

	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6));
		int ans = BinarySearchUtil.singleNonDuplicate(arr);
		System.out.println("The single element is: " + ans);
	}

}
