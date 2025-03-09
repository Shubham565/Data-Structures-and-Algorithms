package com.bhambey.Recursion;

public class Exponent {

	public static void main(String[] args) {
		int num = 5;
		int pow = 2;
		long result = RecursionUtil.power(num, pow);
		System.out.println(num + " power of " + pow + " is: " + result);
	}

}
