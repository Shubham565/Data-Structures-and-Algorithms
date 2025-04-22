package com.bhambey.LinkedLists;

public class FindIntersection {

	public static void main(String[] args) {

		// creation of both lists
		Node common = new Node(8);
		common.next = new Node(10);
		common.next.next = new Node(12);

		// First list: 3 -> 6 -> 9 -> [8 -> 10 -> 12]
		Node head1 = new Node(3);
		head1.next = new Node(6);
		head1.next.next = new Node(9);
		head1.next.next.next = common;

		// Second list: 4 -> [8 -> 10 -> 12]
		Node head2 = new Node(4);
		head2.next = common;
		System.out.print("List1: ");
		LinkedListUtil.printLL(head1);
		System.out.print("List2: ");
		LinkedListUtil.printLL(head2);

		// checking if intersection is present
		Node answerNode = LinkedListUtil.intersectionPresent(head1, head2);
		
		if (answerNode == null)
			System.out.println("No intersection\n");
		else
			System.out.println("The intersection point is " + answerNode.data);

	}

}
