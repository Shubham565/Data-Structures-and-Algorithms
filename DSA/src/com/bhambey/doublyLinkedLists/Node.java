package com.bhambey.doublyLinkedLists;


public class Node {
	// Data stored in the node
	public int data;
	// Reference to the next node in the list (forward direction)
	public Node next;
	// Reference to the previous node in the list (backward direction)
	public Node back;

	// Constructor for a Node with both data, a reference to the next node, and a
	// reference to the previous node
	public Node(int data1, Node next1, Node back1) {
		data = data1;
		next = next1;
		back = back1;
	}

	// Constructor for a Node with data, and no references to the next and previous
	// nodes (end of the list)
	public Node(int data1) {
		data = data1;
		next = null;
		back = null;
	}
}
