package com.bhambey.LinkedLists;

public class LinkedListUtil {

	public static void printLL(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
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

		Node slow = head, fast = head.next;

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

		head.next.next = head;

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

	public static int calculateLoopLength(Node commonNode) {

		Node temp = commonNode;
		int length = 0;

		do {
			length++;
			temp = temp.next;
		} while (temp != commonNode);

		return length;

	}

	public static int lengthOfTheLoop(Node head) {

		Node slow = head, fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				return calculateLoopLength(slow);
			}
		}

		return 0;
	}

	public static boolean isPalindrome(Node head) {

		if (head == null || head.next == null) {
			return true;
		}

		Node fast = head, slow = head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		Node secondHalf = reverseLinkedList(slow);

		Node firstHalf = head;

		// For Optional Restoration
		Node secondHalfNode = secondHalf;

		while (secondHalf != null) {
			if (firstHalf.data != secondHalf.data) {
				return false;
			}

			firstHalf = firstHalf.next;
			secondHalf = secondHalf.next;

		}

		return true;
	}

	public static Node segregateEvenOddNodes(Node head) {

		if (head == null || head.next == null) {
			return head;
		}

		Node evenHead = null, evenTail = null;
		Node oddHead = null, oddTail = null;
		Node current = head;

		while (current != null) {
			if (current.data % 2 == 0) {
				if (evenHead == null) {
					evenHead = evenTail = current;
				} else {
					evenTail.next = current;
					evenTail = evenTail.next;
				}
			} else {
				if (oddHead == null) {
					oddHead = oddTail = current;
				} else {
					oddTail.next = current;
					oddTail = oddTail.next;
				}

			}
			current = current.next;
		}

		if (evenHead == null) {
			return oddHead;
		}

		if (oddHead == null) {
			return evenHead;
		}

		evenTail.next = oddHead;
		oddTail.next = null;

		return evenHead;
	}

	public static Node deleteNthNodefromEnd(Node head, int n) {

		if (head == null) {
			return head;
		}

		Node fast = head;
		Node slow = head;

		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}

		if (fast == null) {
			return head.next;
		}

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		Node delNode = slow.next;
		slow.next = slow.next.next;
		delNode = null;

		return head;
	}

	public static Node deleteMiddle(Node head) {

		if (head == null) {
			return head;
		}

		Node fast = head;
		Node slow = head;
		fast = fast.next.next;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		if (slow.next != null) {
			slow.next = slow.next.next;
		}

		return head;
	}

	private static Node mergeTwoSortedLinkedLists(Node l1, Node l2) {

		Node dummyNode = new Node(-1);
		Node temp = dummyNode;

		while (l1 != null && l2 != null) {
			if (l1.data <= l2.data) {
				temp.next = l1;
				l1 = l1.next;
			} else {
				temp.next = l2;
				l2 = l2.next;
			}
			temp = temp.next;
		}

		if (l1 != null) {
			temp.next = l1;
		} else {
			temp.next = l2;
		}

		return dummyNode.next;
	}

	public static Node sortLL(Node head) {

		if (head == null || head.next == null) {
			return head;
		}

		Node middle = findMiddle(head);

		Node right = middle.next;
		middle.next = null;
		Node left = head;

		left = sortLL(left);
		right = sortLL(right);

		return mergeTwoSortedLinkedLists(left, right);
	}

	public static Node sort012(Node head) {

		if (head == null || head.next == null) {
			return head;
		}

		Node zeroHead = new Node(0);
		Node oneHead = new Node(0);
		Node twoHead = new Node(0);

		Node zero = zeroHead, one = oneHead, two = twoHead;

		Node curr = head;

		while (curr != null) {
			if (curr.data == 0) {
				zero.next = curr;
				zero = zero.next;
			} else if (curr.data == 1) {
				one.next = curr;
				one = one.next;
			} else {
				two.next = curr;
				two = two.next;
			}

			curr = curr.next;
		}

		zero.next = oneHead.next != null ? oneHead.next : twoHead.next;
		one.next = twoHead.next;
		two.next = null;

		return zeroHead.next;
	}

	private static int getDifference(Node head1, Node head2) {

		int len1 = 0, len2 = 0;

		while (head1 != null || head2 != null) {
			if (head1 != null) {
				len1++;
				head1 = head1.next;
			} else if (head2 != null) {
				len2++;
				head2 = head2.next;
			}
		}

		return len1 - len2;
	}
	
	public static Node intersectionPresent(Node head1, Node head2) {

		int diff = getDifference(head1, head2);

		if (diff < 0) {
			while (diff++ != 0)
				head2 = head2.next;
		} else {
			while (diff-- != 0)
				head1 = head1.next;
		}

		while (head1 != null) {
			if (head1 == head2)
				return head1;
			head1 = head1.next;
			head2 = head2.next;
		}

		return head1;
	}

	public static Node plusOne(Node head) {

		Node dummy = new Node(0);
		dummy.next = head;

		Node current = head;

		Node notNine = dummy;

		while (current != null) {
			if (current.data != 9) {
				notNine = current;
			}
			current = current.next;
		}

		notNine.data += 1;

		current = notNine.next;

		while (current != null) {
			current.data = 0;
			current = current.next;
		}

		return dummy.data == 0 ? dummy.next : dummy;
	}

	
	
	
}
