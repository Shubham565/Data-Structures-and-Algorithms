package com.bhambey.Recursion;

public class GCD {

	public static void main(String[] args) {
		int x = 9;
		int y = 5;
		int result = RecursionUtil.gcd(x, y);
		System.out.println("The GCD of " + x + " and " + y + " is:");
		System.out.println(result);
	}

}
