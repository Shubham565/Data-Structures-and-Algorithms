package com.bhambey.doublyLinkedLists;

public class DLLUtil {

	static Node convertArr2DLL(int[] arr) {

		Node head = new Node(arr[0]);
		Node prev = head;

		for (int i = 1; i <= arr.length - 1; i++) {
			Node temp = new Node(arr[i], null, prev);

			prev.next = temp;

			prev = temp;
		}

		return head;

	}

	static void print(Node head) {
		while (head != null) {
			// Print the data in the current node
			System.out.print(head.data + " ");
			// Move to the next node
			head = head.next; // Move to the next node
		}
		System.out.println();
	}

	public static Node insertAtTail(Node head, int val) {

		Node temp = head;
		Node newNode = new Node(val);

		if (head == null)
			return newNode;

		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = newNode;
		newNode.back = temp;

		return head;
	}

	public static Node deleteTail(Node head) {

		if (head == null || head.next == null)
			return null;

		Node temp = head;

		while (temp.next.next != null) {
			temp = temp.next;
		}

		temp.next.back = null;
		temp.next = null;

		return head;
	}

	
	public static Node reverseDLL(Node head) {

		if(head == null || head.next == null) return head;
		
		Node curr = head;
		
		Node prev = null;
		
		while(curr != null)
		{
			prev = curr.back;
			
			curr.back = curr.next;
			
			curr.next = prev;
			
			curr = curr.back;
		}
		
		return prev.back;
	}

}
