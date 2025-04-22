package com.bhambey.LinkedLists;

public class RemoveNthNodeFromEnd {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
        int N = 3;
        Node head = new Node(arr[0]);
        head.next = new Node(arr[1]);
        head.next.next = new Node(arr[2]);
        head.next.next.next = new Node(arr[3]);
        head.next.next.next.next = new Node(arr[4]);

        // Delete the Nth node from the end and print the modified linked list
        head = LinkedListUtil.deleteNthNodefromEnd(head, N);
        LinkedListUtil.printLL(head);
	}

}
