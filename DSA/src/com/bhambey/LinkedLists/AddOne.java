package com.bhambey.LinkedLists;

public class AddOne {

	public static void main(String[] args) {
		

        // Example 1: 1 -> 2 -> 3
		Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        LinkedListUtil.printLL(LinkedListUtil.plusOne(head1)); // Output: 1 -> 2 -> 4

        // Example 2: 9 -> 9
        Node head2 = new Node(9);
        head2.next = new Node(9);
        LinkedListUtil.printLL(LinkedListUtil.plusOne(head2)); // Output: 1 -> 0 -> 0
	}

}
