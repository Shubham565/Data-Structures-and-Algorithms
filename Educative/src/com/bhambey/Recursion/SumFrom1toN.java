package com.bhambey.Recursion;

public class SumFrom1toN {

	public static void main(String[] args) {
		int input = 5;
		int sum = RecursionUtil.sumAll(input);
		System.out.println("The sum of integers from 1 to " + input + " is: " + sum);
	}

}
