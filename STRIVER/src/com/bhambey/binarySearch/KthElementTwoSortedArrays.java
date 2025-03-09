package com.bhambey.binarySearch;

import java.util.*;

public class KthElementTwoSortedArrays {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(2);
		a.add(3);
		a.add(6);
		a.add(7);
		a.add(9);

		ArrayList<Integer> b = new ArrayList<>();
		b.add(1);
		b.add(4);
		b.add(8);
		b.add(10);

		System.out.println("The k-th element of two sorted arrays is: " + BinarySearchUtil.kthElementTwoSortedArrays(a, b, a.size(), b.size(), 5));
	}

}
