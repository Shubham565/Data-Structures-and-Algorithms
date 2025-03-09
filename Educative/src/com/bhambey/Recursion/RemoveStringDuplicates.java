package com.bhambey.Recursion;

public class RemoveStringDuplicates {

	public static void main(String[] args) {
		String input1 = "Helloo";
		String input2 = "Thiss iiss aa teesstt";

		System.out.println("Original string: " + input1);

		String output = RecursionUtil.remDuplicates(input1);

		System.out.println("String after: " + output);
	}

}
