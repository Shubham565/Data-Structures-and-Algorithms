package com.bhambey.strings;

public class StringRotation {

	public static void main(String[] args) {

		String s1 = "abcde";
		String s2 = "cdeab";

		System.out.println("Given string is a rotation of the other: " + StringsUtil.rotateString(s1, s2));

	}

}
