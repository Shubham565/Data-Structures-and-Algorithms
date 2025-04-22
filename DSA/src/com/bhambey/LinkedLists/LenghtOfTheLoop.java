package com.bhambey.LinkedLists;

public class LenghtOfTheLoop {

	public static void main(String[] args) {

		// Create a linked list with a loop
		Node head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);

		// Create a loop from fifth to second
		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;

		// This creates a loop
		fifth.next = second;

		int loopLength = LinkedListUtil.lengthOfTheLoop(head);

		if (loopLength > 0) {
			System.out.println("Length of the loop: " + loopLength);
		} else {
			System.out.println("No loop found in the linked list.");
		}

	}

}
