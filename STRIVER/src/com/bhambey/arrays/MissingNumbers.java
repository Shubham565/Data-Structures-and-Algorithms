package com.bhambey.arrays;

public class MissingNumbers {

	public static void main(String[] args) {

		int N = 5;
        int a[] = {1, 2, 4, 5};

        int ans = ArrayUtil.missingNumber(a, N);
        System.out.println("The missing number is: " + ans);
		
	}

}
