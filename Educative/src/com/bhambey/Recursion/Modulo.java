package com.bhambey.Recursion;

public class Modulo {

	public static void main(String[] args) {

		int dividend = 27;
		int divisor = 4;
		int remainder = RecursionUtil.mod(dividend, divisor);
		System.out.println(dividend + " mod " + divisor + " = " + remainder);

	}

}
