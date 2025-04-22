package com.bhambey.LinkedLists;

public class SortingLinkedLIst {

	public static void main(String[] args) {
		// Linked List: 3 2 5 4 1
		Node head = new Node(3);
		head.next = new Node(2);
		head.next.next = new Node(5);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(1);
		head.next.next.next.next.next = new Node(7);
		//head.next.next.next.next.next.next = new Node(6);

		System.out.print("Original Linked List: ");
		LinkedListUtil.printLL(head);

		// Sort the linked list
		head = LinkedListUtil.sortLL(head);

		System.out.print("Sorted Linked List: ");
		LinkedListUtil.printLL(head);
	}

}
