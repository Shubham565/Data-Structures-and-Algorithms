package com.bhambey.LinkedLists;

public class LinkedListUtil {

	public static void printLL(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	public static Node insertAtHead(Node head, int val) {
		Node temp = new Node(val, head);
		return temp;
	}

	public static Node deleteTail(Node head) {

		if (head == null || head.next == null) {
			return null;
		}

		Node temp = head;

		while (temp.next.next != null) {
			temp = temp.next;
		}

		temp.next = null;

		return head;
	}

	public static int lengthOfLinkedList(Node head) {

		int count = 0;

		Node temp = head;

		while (temp != null) {
			temp = temp.next;
			count++;
		}

		return count;
	}

	public static boolean checkifPresent(Node head, int val) {

		boolean flag = false;
		Node temp = head;

		while (temp != null) {
			if (temp.data == val)
				flag = true;
			temp = temp.next;
		}
		
		return flag;
	}

	public static Node findMiddle(Node head) {

		Node slow = head, fast = head;

		while (fast != null && fast.next != null && slow != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}

	public static Node reverseLinkedList(Node head) {

		Node prev = null;
		Node curr = head;

		while (curr != null) {
			Node front = curr.next;
			curr.next = prev;
			prev = curr;
			curr = front;
		}

		return prev;
	}

	public static Node reverseLinkedListRecursive(Node head) {

		if (head == null || head.next == null) {
			return head;
		}

		Node newHead = reverseLinkedListRecursive(head.next);

		Node front = head.next;

		front.next = head;

		head.next = null;

		return newHead;
	}

	
	public static boolean detectCycle(Node head) {

		Node fast = head, slow = head;

		while (fast.next != null || fast != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (fast == slow)
				return true;
		}

		return false;
	}

	
	public static Node startOfTheLoop(Node head) {

		/*
		 * Time Complexity: O(N) The code traverses the entire linked list once, where
		 * 'n' is the number of nodes in the list. This traversal has a linear time
		 * complexity, O(n).
		 * 
		 * Space Complexity : O(1) The code uses only a constant amount of additional
		 * space, regardless of the linked list's length. This is achieved by using two
		 * pointers (slow and fast) to detect the loop without any significant extra
		 * memory usage, resulting in constant space complexity, O(1).
		 */

		Node fast = head, slow = head;

		if (head == null || head.next == null) {
			return head;
		}

		Node temp = head;

		while (fast.next != null && fast != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (fast == slow) {
				slow = head;

				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}

				return slow;

			}
		}

		return null;
	}
	
	
	
}
