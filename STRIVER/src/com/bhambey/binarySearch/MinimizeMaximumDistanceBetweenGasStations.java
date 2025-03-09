package com.bhambey.binarySearch;

public class MinimizeMaximumDistanceBetweenGasStations {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        double ans = BinarySearchUtil.minimizeMaximumDistanceBetweenGasStations(arr, k);
        System.out.println("The answer is: " + ans);
	}
	
}
