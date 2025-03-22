package com.bhambey.LinkedLists;

public class ReverseLinkedListIterative {

	public static void main(String[] args) {

		// Create a linked list with values 1, 3, 2, and 4
		Node head = new Node(1);
		head.next = new Node(3);
		head.next.next = new Node(2);
		head.next.next.next = new Node(4);

		// Print the original linked list
		System.out.print("Original Linked List: ");
		LinkedListUtil.printLL(head);

		// Reverse the linked list
		head = LinkedListUtil.reverseLinkedList(head);

		// Print the reversed linked list
		System.out.print("Reversed Linked List: ");
		LinkedListUtil.printLL(head);

	}

}
