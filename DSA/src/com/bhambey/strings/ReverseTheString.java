package com.bhambey.strings;

public class ReverseTheString {

	public static void main(String[] args) {
		String st = "TUF is great for interview preparation";
		System.out.println("Before reversing words: ");
		System.out.println(st);
		System.out.println("After reversing words: ");
		System.out.print(StringsUtil.reverseTheString(st));
	}

}
