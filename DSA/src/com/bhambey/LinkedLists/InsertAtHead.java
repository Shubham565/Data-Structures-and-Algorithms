package com.bhambey.LinkedLists;

import java.util.*;

public class InsertAtHead {

	public static void main(String[] args) {
		 // Sample array and value for insertion
        List<Integer> arr = Arrays.asList(12, 8, 5, 7);
        int val = 100;

        // Creating a linked list with initial elements from the array
        Node head = new Node(arr.get(0));
        head.next = new Node(arr.get(1));
        head.next.next = new Node(arr.get(2));
        head.next.next.next = new Node(arr.get(3));

        // Inserting a new node at the head of the linked list
        head = LinkedListUtil.insertAtHead(head, val);

        // Printing the linked list
        LinkedListUtil.printLL(head);
	}

}
