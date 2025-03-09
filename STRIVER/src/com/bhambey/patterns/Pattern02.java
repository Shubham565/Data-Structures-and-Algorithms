package com.bhambey.patterns;

/*
Input Format: N = 3

Result: 
* 
* * 
* * *

*/

public class Pattern02 {

	public static void main(String[] args) {

		printPattern(5);

	}

	private static void printPattern(int n) {

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}

	}

}
