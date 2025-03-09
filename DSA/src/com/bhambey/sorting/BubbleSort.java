package com.bhambey.sorting;

import java.util.Random;

public class BubbleSort {

	static int size = 8;
	static Random random = new Random(System.currentTimeMillis());
	static int[] input = new int[size];

	public static void main(String[] args) {
		createTestData();
		long start = System.currentTimeMillis();
		SortingUtil.bubbleSort(input, size);
		long end = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			System.out.print(input[i] + ", ");
		}
		System.out.println("Time taken = " + (end - start));
	}

	static void createTestData() {
		for (int i = 0; i < size; i++) {
			input[i] = random.nextInt(200);
		}
	}

}
