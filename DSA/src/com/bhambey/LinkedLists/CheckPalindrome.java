package com.bhambey.LinkedLists;

public class CheckPalindrome {

	public static void main(String[] args) {

		// Create a linked list with
		// values 1, 5, 2, 5, and 1 (15251, a palindrome)
		Node head = new Node(1);
		head.next = new Node(5);
		head.next.next = new Node(2);
		head.next.next.next = new Node(5);
		head.next.next.next.next = new Node(1);

		// Print the original linked list
		System.out.print("Original Linked List: ");
		LinkedListUtil.printLL(head);

		// Check if the linked list is a palindrome
		if (LinkedListUtil.isPalindrome(head)) {
			System.out.println("The linked list is a palindrome.");
		} else {
			System.out.println("The linked list is not a palindrome.");
		}

	}

}
