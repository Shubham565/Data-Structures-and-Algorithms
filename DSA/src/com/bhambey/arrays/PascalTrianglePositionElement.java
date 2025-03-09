package com.bhambey.arrays;

public class PascalTrianglePositionElement {

	public static void main(String[] args) {
		int r = 5; // row number
		int c = 3; // col number
		int element = ArrayUtil.pascalTrianglePositionElement(r, c);
		System.out.println("The element at position (r,c) is: " + element);
	}

}
