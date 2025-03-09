package com.bhambey.patterns;

/*
Input: N = 3

Result: 
  *  
 *** 
*****

*/

public class Pattern06 {

	public static void main(String[] args) {

		printPattern(5);

	}

	private static void printPattern(int n) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * i + 1; j++) {
				System.out.print("*");
			}

			System.out.println();
		}

	}

}
