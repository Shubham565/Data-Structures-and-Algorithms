package com.bhambey.LinkedLists;

public class DeleteLastNode {

	public static void main(String[] args) {
		// Initialize an array with integer values
		int[] arr = { 2, 5, 8, 7 };
		// Create the linked list with nodes initialized with array values
		Node head = new Node(arr[0]);
		head.next = new Node(arr[1]);
		head.next.next = new Node(arr[2]);
		head.next.next.next = new Node(arr[3]);
		
		// Delete the tail of the linked list
		head = LinkedListUtil.deleteTail(head);
		
		// Print the modified linked list
		LinkedListUtil.printLL(head);
	}

}
