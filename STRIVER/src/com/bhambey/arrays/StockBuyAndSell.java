package com.bhambey.arrays;

public class StockBuyAndSell {

	
	public static void main(String[] args) {
		int arr[] = {7,1,5,3,6,4};

	    int maxPro = ArrayUtil.stockBuyAndSell(arr);
	    System.out.println("Max profit is: " + maxPro);
	}
}
