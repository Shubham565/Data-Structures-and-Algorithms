package com.bhambey.LinkedLists;

public class Node {

	public int data;
	public Node next;

	// Constructor with both data and next node
	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}

	// Constructor with only data (assuming next is initially null),
	public Node(int data) {
		this.data = data;
		this.next = null;
	}

}
