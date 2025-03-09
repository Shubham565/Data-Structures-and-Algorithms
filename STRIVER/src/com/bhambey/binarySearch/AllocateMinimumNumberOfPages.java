package com.bhambey.binarySearch;

import java.util.*;

public class AllocateMinimumNumberOfPages {

	public static void main(String[] args) {

		List<Integer> arr = new ArrayList<>(Arrays.asList(25, 46, 28, 49, 24));
		int numberOfBooks = 5;
		int numberOfStudents = 4;
		int ans = BinarySearchUtil.allocateMinimumNumberOfPages(arr, numberOfBooks, numberOfStudents);
		System.out.println("The answer is: " + ans);

	}

}
