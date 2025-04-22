package com.bhambey.LinkedLists;

public class Sort012 {

	public static void main(String[] args) {

		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(0);
		head.next.next.next = new Node(0);
		head.next.next.next.next = new Node(2);
		head.next.next.next.next.next = new Node(2);
		head.next.next.next.next.next.next = new Node(1);
		//head.next.next.next.next.next.next = new Node(6);

		System.out.print("Original Linked List: ");
		LinkedListUtil.printLL(head);

		// Sort the linked list
		head = LinkedListUtil.sort012(head);

		System.out.print("Sorted Linked List: ");
		LinkedListUtil.printLL(head);
		
	}

}
