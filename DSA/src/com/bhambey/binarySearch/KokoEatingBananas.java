package com.bhambey.binarySearch;

public class KokoEatingBananas {

	public static void main(String[] args) {
		int[] v = {25, 12, 8, 14, 19};
		int h = 5;
		int ans = BinarySearchUtil.kokoEatingBananas(v, h);
		System.out.println("Koko should eat at least " + ans + " bananas/hr.");
	}

}
