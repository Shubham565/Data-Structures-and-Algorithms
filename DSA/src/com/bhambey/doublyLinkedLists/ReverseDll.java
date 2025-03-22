package com.bhambey.doublyLinkedLists;

public class ReverseDll {

	public static void main(String[] args) {
		int[] arr = { 12, 5, 6, 8, 4 };
		// Convert the array to a doubly linked list
		Node head = DLLUtil.convertArr2DLL(arr);

		// Print the doubly linked list
		System.out.println("Doubly Linked List Initially:  ");
		DLLUtil.print(head);

		System.out.println("Doubly Linked List After Reversing :");

		head = DLLUtil.reverseDLL(head);
		DLLUtil.print(head);
	}

}
