package com.bhambey.LinkedLists;

public class MiddleOfLinkedList {

	public static void main(String[] args) {

		// Creating a sample linked list:
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);

		// Find the middle node
		Node middleNode = LinkedListUtil.findMiddle(head);

		// Display the value of the middle node
		System.out.println("The middle node value is: " + middleNode.data);

	}

}
