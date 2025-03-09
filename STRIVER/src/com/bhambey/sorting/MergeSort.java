package com.bhambey.sorting;

import java.util.Random;

public class MergeSort {
	static int SIZE = 8;
	static Random random = new Random(System.currentTimeMillis());
	static int[] input = new int[SIZE];
	
	// Uncomment for using array as auxillary DS
	//static int[] scratch = new int[SIZE];

	public static void main(String args[]) {
		createTestData();
		long start = System.currentTimeMillis();
		SortingUtil.mergeSortArrayList(0, input.length - 1, input);
		long end = System.currentTimeMillis();
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
		System.out.println();
		System.out.print("Time taken = " + (end - start));
	}

	static void createTestData() {
		for (int i = 0; i < SIZE; i++) {
			input[i] = random.nextInt(40);
		}
	}
}
