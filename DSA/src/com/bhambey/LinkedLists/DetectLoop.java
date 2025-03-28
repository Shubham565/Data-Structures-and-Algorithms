package com.bhambey.LinkedLists;

public class DetectLoop {

	public static void main(String[] args) {
		Node head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);

		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = third;

		if (LinkedListUtil.detectCycle(head)) {
			System.out.println("Loop detected in the linked list.");
		} else {
			System.out.println("No loop detected in the linked list.");
		}

	}
}
