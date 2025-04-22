package com.bhambey.LinkedLists;

public class RemoveFromMiddle {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);

		// Display the original linked list
		System.out.print("Original Linked List: ");
		LinkedListUtil.printLL(head);

		// Deleting the middle node
		head = LinkedListUtil.deleteMiddle(head);

		// Displaying the updated linked list
		System.out.print("Updated Linked List: ");
		LinkedListUtil.printLL(head);
	}

}
