package com.bhambey.binarySearch;

public class ShipPackagesWithinGivenDays {

	public static void main(String[] args) {
		int[] weights = {5, 4, 5, 2, 3, 4, 5, 6};
        int d = 5;
        int ans = BinarySearchUtil.shipPackagesWithinGivenDays(weights, d);
        System.out.println("The minimum capacity should be: " + ans);
	}

}
