package com.bhambey.LinkedLists;

public class SearchForaAValue {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		Node head = new Node(arr[0]);
		head.next = new Node(arr[1]);
		head.next.next = new Node(arr[2]);

		int val = 5; // Element to be checked for presence in the linked list

		// Call the checkifPresent function and print the result
		System.out.print(LinkedListUtil.checkifPresent(head, val));
	}

}
