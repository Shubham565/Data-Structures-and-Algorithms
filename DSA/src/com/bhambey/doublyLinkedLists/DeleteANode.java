package com.bhambey.doublyLinkedLists;

public class DeleteANode {

	public static void main(String[] args) {
		int[] arr = { 12, 5, 6, 8 };
		Node head = DLLUtil.convertArr2DLL(arr); // Convert the array to a doubly linked list
		DLLUtil.print(head); // Print the doubly linked list

		System.out.println("Doubly Linked List after deleting tail node: ");
		head = DLLUtil.deleteTail(head);
		DLLUtil.print(head);
	}

}
