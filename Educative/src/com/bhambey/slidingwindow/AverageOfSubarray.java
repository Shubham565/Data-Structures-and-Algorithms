package com.bhambey.slidingwindow;

import java.util.Arrays;

public class AverageOfSubarray {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 6, -1, 4, 1, 8, 2 };
		int k = 5;
		double[] result = findAverage(arr, k);
		System.out.println(Arrays.toString(result));
	}

	private static double[] findAverage(int[] arr, int k) {

		double[] res = new double[arr.length - k + 1];
		double winSum = 0;
		int winStart = 0;

		for (int winEnd = 0; winEnd < arr.length; winEnd++) {
			winSum += arr[winEnd];
			if (winEnd >= k - 1) {
				res[winStart] = winSum / k;
				winSum -= arr[winStart];
				winStart++;
			}
		}

		return res;
	}

}
