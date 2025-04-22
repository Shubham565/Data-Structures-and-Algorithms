package com.bhambey.LinkedLists;

public class SegregateEvenOddNodes {

	public static void main(String[] args) {

		Node head = new Node(1);
		head.next = new Node(3);
		head.next.next = new Node(2);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);

		// Print the original linked list
		//System.out.print("Original Linked List: ");
		//LinkedListUtil.printLL(head);

		Node newHead = LinkedListUtil.segregateEvenOddNodes(head);
		LinkedListUtil.printLL(newHead);

	}

}
