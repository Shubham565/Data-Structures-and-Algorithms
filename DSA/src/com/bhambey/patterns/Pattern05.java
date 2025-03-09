package com.bhambey.patterns;

/*
Input: N = 3

Result: 
* * *
* * 
*

*/

public class Pattern05 {
	public static void main(String[] args) {

		printPattern(5);

	}

	private static void printPattern(int n) {

		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}

	}
}
