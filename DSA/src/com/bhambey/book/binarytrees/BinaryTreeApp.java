package com.bhambey.book.binarytrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

class Node {
	Node left;
	Node right;
	int data;
}

class Tuple {
	Node node;
	int row;
	int col;

	public Tuple(Node _node, int _col, int _row) {
		node = _node;
		_col = col;
		_row = row;
	}
}

class Pair {
	int hd;
	Node node;

	public Pair(int hd, Node node) {
		this.node = node;
		this.hd = hd;
	}
}

class BinaryTree {

	public Node createNewNode(int val) {
		Node newNode = new Node();
		newNode.data = val;
		newNode.left = null;
		newNode.right = null;
		return newNode;
	}

	public Node insert(Node node, int val) {

		if (node == null) {
			return createNewNode(val);
		}

		if (val < node.data) {
			node.left = insert(node.left, val);
		} else if (val > node.data) {
			node.right = insert(node.right, val);
		}
		return node;
	}

	public void PreOrderRecursive(Node root) {
		if (root == null) {
			return;
		}

		System.out.print(root.data + " ");
		PreOrderRecursive(root.left);
		PreOrderRecursive(root.right);

	}

	public void PreOrderIterative(Node root) {
		if (root == null) {
			return;
		}

		List<Integer> list = new ArrayList<>();

		Stack<Node> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			Node temp = stack.pop();
			list.add(temp.data);
			if (temp.right != null)
				stack.push(temp.right);
			if (temp.left != null)
				stack.push(temp.left);

		}

		for (Integer i : list) {
			System.out.print(i + " ");
		}

	}

	public void InOrderRecursive(Node root) {
		if (root == null)
			return;

		InOrderRecursive(root.left);
		System.out.print(root.data + " ");
		InOrderRecursive(root.right);

	}

	public void InOrderIterative(Node root) {
		if (root == null)
			return;

		Stack<Node> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();

		Node current = root;

		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			list.add(current.data);
			current = current.right;
		}

		for (Integer i : list) {
			System.out.print(i + " ");
		}

	}

	public void postOrderRecursive(Node root) {

		if (root == null)
			return;

		postOrderRecursive(root.left);
		postOrderRecursive(root.right);
		System.out.print(root.data + " ");

	}

	// Post order using 2 stacks
	public void postOrderTwoStacks(Node root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return;
		Stack<Node> s1 = new Stack<>(), s2 = new Stack<>();
		s1.push(root);

		while (!s1.isEmpty()) {
			root = s1.pop();
			s2.push(root);
			if (root.left != null)
				s1.push(root.left);
			if (root.right != null)
				s1.push(root.right);
		}

		while (!s2.isEmpty()) {
			list.add(s2.pop().data);
		}

		for (Integer i : list) {
			System.out.print(i + " ");
		}

	}

	// Post Order single stack
	public void postOrderSingleStack(Node root) {

		if (root == null)
			return;

		Node current = root;
		Stack<Node> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();

		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				Node temp = stack.peek().right;
				if (temp == null) {
					temp = stack.pop();
					list.add(temp.data);
					while (!stack.isEmpty() && temp == stack.peek().right) {
						temp = stack.pop();
						list.add(temp.data);
					}
				} else {
					current = temp;
				}
			}
		}

		for (Integer i : list) {
			System.out.print(i + " ");
		}

	}

	public void levelOrder(Node root) {
		if (root == null)
			return;

		Queue<Node> q = new LinkedList<>();
		q.offer(root);

		while (!q.isEmpty()) {
			root = q.poll();
			System.out.print(root.data + " ");
			if (root.left != null) {
				q.add(root.left);
			}
			if (root.right != null) {
				q.add(root.right);
			}
		}

	}

	public int maximumElement(Node root) {

//		int max = Integer.MIN_VALUE;
//		if (root != null) {
//			int leftMax = maximumElement(root.left);
//			int rightMax = maximumElement(root.right);
//
//			if (leftMax > rightMax)
//				max = leftMax;
//			else
//				max = rightMax;
//
//			if (root.data > max)
//				max = root.data;
//
//		}
//
//		return max;

		if (root == null)
			return Integer.MIN_VALUE;

		Queue<Node> q = new LinkedList<>();
		int max = Integer.MIN_VALUE;
		q.offer(root);

		while (!q.isEmpty()) {
			Node temp = q.poll();
			if (temp.data > max)
				max = temp.data;
			if (temp != null) {
				if (temp.left != null)
					q.offer(temp.left);
				if (temp.right != null)
					q.offer(temp.right);
			}

		}
		return max;
	}

	public boolean searchElement(Node root, int i) {

		if (root == null)
			return false;

//		if (root.data == i)
//			return true;
//
//		return searchElement(root.left, i) || searchElement(root.right, i);
		Queue<Node> q = new LinkedList<>();

		q.offer(root);

		while (!q.isEmpty()) {
			Node temp = q.poll();
			if (temp.data == i)
				return true;
			if (temp != null) {
				if (temp.left != null)
					q.offer(temp.left);
				if (temp.right != null)
					q.offer(temp.right);
			}
		}
		return false;
	}

	public Node insertElement(Node root, int i) {
		if (root == null)
			return null;

		Queue<Node> q = new LinkedList<>();
		q.offer(root);

		while (!q.isEmpty()) {
			Node temp = q.poll();
			if (temp != null) {
				if (temp.left != null) {
					q.offer(temp.left);
				} else {
					temp.left = createNewNode(i);
					return root;
				}

				if (temp.right != null) {
					q.offer(temp.right);
				} else {
					temp.right = createNewNode(i);
					return root;
				}
			}
		}
		return root;
	}

	public int heightOfTree(Node root) {

		if (root == null)
			return 0;

		return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;

	}

	public int heightOfTreeIterative(Node root) {
		if (root == null)
			return 0;

		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		int h = 0;
		while (true) {
			int size = q.size();
			if (size == 0) {
				return h;
			}
			h++;

			while (size > 0) {
				Node node = q.poll();
				if (node.left != null)
					q.offer(node.left);
				if (node.right != null)
					q.offer(node.right);
				size--;
			}

		}

	}

	public Node deepestNode(Node root) {
		if (root == null)
			return null;

		Queue<Node> q = new LinkedList<>();
		Node temp = null;
		q.offer(root);

		while (!q.isEmpty()) {
			temp = q.poll();
			if (temp.left != null)
				q.offer(temp.left);
			if (temp.right != null)
				q.offer(temp.right);

		}
		return temp;
	}

	public int diameterOfTree(Node root) {

		int[] diameter = new int[1];
		heightForDiameter(root, diameter);
		return diameter[0];
	}

	private int heightForDiameter(Node root, int[] diameter) {

		if (root == null)
			return 0;
		int lh = heightForDiameter(root.left, diameter);
		int rh = heightForDiameter(root.right, diameter);

		diameter[0] = Math.max(diameter[0], lh + rh);

		return 1 + Math.max(lh, rh);

	}

	public int maximumSumLevel(Node root) {

		if (root == null)
			return 0;

		int maxSum = Integer.MIN_VALUE, maxLevel = 0, currLevel = 1;
		Queue<Node> q = new LinkedList<>();
		q.offer(root);

		while (!q.isEmpty()) {
			int sum = 0;
			int size = q.size();
			while (size > 0) {
				Node temp = q.poll();
				sum += temp.data;

				if (temp.left != null)
					q.offer(temp.left);
				if (temp.right != null)
					q.offer(temp.right);

				size--;
			}
			if (sum > maxSum) {
				maxSum = sum;
				maxLevel = currLevel;
			}
			currLevel++;
		}
		return maxLevel;
	}

	public List<String> printAllPaths(Node root) {
		if (root == null)
			return null;

		List<String> list = new ArrayList<>();
		pathHelper(root, String.valueOf(root.data), list);
		return list;

	}

	private void pathHelper(Node root, String s, List<String> list) {
		if (root.left == null && root.right == null)
			list.add(s);
		String delimiter = "->";
		if (root.left != null)
			pathHelper(root.left, s + delimiter + root.left.data, list);
		if (root.right != null)
			pathHelper(root.right, s + delimiter + root.right.data, list);
	}

	public boolean pathSum(Node root, int sum) {
		if (root == null)
			return false;

		if (root.left == null && root.right == null && root.data == sum)
			return true;
		else
			return pathSum(root.left, sum - root.data) || pathSum(root.right, sum - root.data);

	}

	public void verticalSum(Node root) {
		if (root == null)
			return;

		TreeMap<Integer, Integer> tm = new TreeMap<>();

		verticalSumHelper(root, 0, tm);

		if (tm != null)
			System.out.println(tm.entrySet());

	}

	private void verticalSumHelper(Node root, int horizontalDistance, TreeMap<Integer, Integer> tm) {

		if (root == null)
			return;

		verticalSumHelper(root.left, horizontalDistance - 1, tm);

		tm.put(horizontalDistance, tm.getOrDefault(horizontalDistance, 0) + root.data);

		verticalSumHelper(root.right, horizontalDistance + 1, tm);
	}

	public boolean ancestors(Node root, int val) {

		if (root == null)
			return false;

		if (root.data == val)
			return true;

		if (ancestors(root.left, val) || ancestors(root.right, val)) {
			System.out.println(root.data);
			return true;
		}
		return false;

	}

	public int kthsmallestElementBST(Node root, int k) {

		Stack<Node> s = new Stack<>();

		while (true) {
			while (root != null) {
				s.push(root);
				root = root.left;
			}

			root = s.pop();
			if (k - 1 == 0)
				return root.data;
			root = root.right;
			// Replace right and left node being iterated for kth largest element
		}

	}

	int globalFlag = 0;
	Node parent = null, head = null;

	public Node binaryTreeToDLL(Node root) {

		if (root == null)
			return null;

		binaryTreeToDLL(root.left);

		if (globalFlag == 0) {
			parent = head = root;
			globalFlag = 1;
		} else {
			root.left = parent;
			parent.right = root;
			parent = root;
		}
		binaryTreeToDLL(root.right);

		return head;

	}

	Node prev = null;

	public void flattenToLL(Node root) {

		if (root == null)
			return;

		flattenToLL(root.right);
		flattenToLL(root.left);

		root.right = prev;
		root.left = null;
		prev = root;

	}

	// CHECK THIS ONE
	public void flattenToLLIterative(Node root) {
		if (root == null)
			return;

		Stack<Node> s = new Stack<>();
		s.push(root);

		while (!s.isEmpty()) {
			Node curr = s.pop();
			if (curr.right != null) {
				s.push(root.right);
			}

			if (curr.left != null) {
				s.push(root.left);
			}

			if (!s.isEmpty()) {
				curr.right = s.peek();
			}
			curr.left = null;
		}

	}

	public boolean checkIfBTIsBalanced(Node root) {

		if (root == null)
			return true;

		return Math.abs(heightOfTree(root.left) - heightOfTree(root.right)) <= 1 && checkIfBTIsBalanced(root.left)
				&& checkIfBTIsBalanced(root.right);
	}

	public void allNodesAtKDistance(Node root, int k) {
		if (root == null)
			return;

		if (k == 0) {
			System.out.print(root.data + " ");
			return;
		} else {
			allNodesAtKDistance(root.left, k - 1);
			allNodesAtKDistance(root.right, k - 1);

		}

	}

	public Node deleteNodeFromBST(Node root, int k) {

		if (root == null)
			return null;

		if (k < root.data) {
			root.left = deleteNodeFromBST(root.left, k);
		} else if (k > root.data) {
			root.right = deleteNodeFromBST(root.right, k);
		} else {
			if (root.left == null) {
				return root.right;
			}
			if (root.right == null) {
				return root.left;
			}

			Node rightMin = root.right;
			while (rightMin.left != null)
				rightMin = rightMin.left;
			rightMin.left = root.left;
			return root.right;
		}
		return root;
	}

	public List<Integer> nodesAtKDistanceFromGivenNode(Node root, Node target, int k) {

		Map<Node, Node> parentTrack = new HashMap<>();
		markParents(root, parentTrack);
		Map<Node, Boolean> visited = new HashMap<>();
		Queue<Node> q = new LinkedList<>();
		q.offer(target);
		visited.put(target, true);
		int currLevel = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			if (currLevel == k)
				break;
			currLevel++;
			for (int i = 0; i < size; i++) {
				Node curr = q.poll();
				if (curr.left != null && visited.get(curr.left) == null) {
					q.offer(curr.left);
					visited.put(curr.left, true);
				}
				if (curr.right != null && visited.get(curr.right) == null) {
					q.offer(curr.right);
					visited.put(curr.right, true);
				}
				if (parentTrack.get(curr) != null && visited.get(parentTrack.get(curr)) == null) {
					q.offer(parentTrack.get(curr));
					visited.put(parentTrack.get(curr), true);
				}

			}
		}

		List<Integer> result = new ArrayList<>();
		while (!q.isEmpty()) {
			Node curr = q.poll();
			result.add(curr.data);
		}
		return result;

	}

	public void markParents(Node root, Map<Node, Node> parentTrack) {
		Queue<Node> q = new LinkedList<>();
		q.offer(root);

		while (!q.isEmpty()) {
			Node curr = q.poll();
			if (curr.left != null) {
				parentTrack.put(curr.left, curr);
				q.offer(curr.left);
			}
			if (curr.right != null) {
				parentTrack.put(curr.right, curr);
				q.offer(curr.right);
			}
		}

	}

	public void distanceKFromLeafNodes(Node root, int k, int[] arr, boolean[] visited, int count) {

		if (root == null)
			return;

		arr[count] = root.data;
		visited[count] = false;

		if (root.left == null && root.right == null && count - k >= 0 && visited[count - k] == false) {
			System.out.print(arr[count - k] + " ");
			visited[count - k] = true;
			return;
		}

		distanceKFromLeafNodes(root.left, k, arr, visited, count + 1);
		distanceKFromLeafNodes(root.right, k, arr, visited, count + 1);

	}

	public List<Integer> boundaryNodesAntiClockwise(Node root) {

		List<Integer> ans = new ArrayList<>();
		if (isLeaf(root) == false) {
			ans.add(root.data);
		}
		addLeftBoundary(root, ans);
		addLeafNodes(root, ans);
		addRightBoundary(root, ans);

		return ans;

	}

	public void addLeftBoundary(Node root, List<Integer> res) {

		Node curr = root.left;
		while (curr != null) {
			if (isLeaf(curr) == false)
				res.add(curr.data);
			if (curr.left != null)
				curr = curr.left;
			else
				curr = curr.right;
		}

	}

	public void addRightBoundary(Node root, List<Integer> res) {
		Node curr = root.right;
		List<Integer> temp = new ArrayList<>();
		while (curr != null) {
			if (isLeaf(curr) == false)
				temp.add(curr.data);
			if (curr.right != null)
				curr = curr.right;
			else
				curr = curr.left;
		}

		for (int i = temp.size() - 1; i >= 0; --i) {
			res.add(temp.get(i));
		}

	}

	public void addLeafNodes(Node root, List<Integer> res) {

		if (isLeaf(root) == true) {
			res.add(root.data);
			return;
		}

		if (root.left != null)
			addLeafNodes(root.left, res);
		if (root.right != null)
			addLeafNodes(root.right, res);
	}

	public boolean isLeaf(Node node) {

		if (node.left == null && node.right == null) {
			return true;
		} else {
			return false;
		}

	}

	public boolean validateGivenBST(Node root, long minVal, long maxVal) {

		if (root == null)
			return true;
		if (root.data <= minVal || root.data >= maxVal)
			return false;
		return (validateGivenBST(root.left, minVal, root.data) && validateGivenBST(root.right, root.data, maxVal));

	}

	// TBD
	public List<List<Integer>> verticalTraversalBinaryTree(Node root) {

		TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
		Queue<Tuple> q = new LinkedList<>();
		q.offer(new Tuple(root, 0, 0));

		while (!q.isEmpty()) {
			Tuple tuple = q.poll();
			Node node = tuple.node;
			int x = tuple.row;
			int y = tuple.col;

			if (!map.containsKey(x)) {
				map.put(x, new TreeMap<>());
			}
			if (!map.get(x).containsKey(y)) {
				map.get(x).put(y, new PriorityQueue<>());
			}
			map.get(x).get(y).offer(node.data);

			if (node.left != null) {
				q.offer(new Tuple(node.left, x - 1, y + 1));
			}
			if (node.right != null) {
				q.offer(new Tuple(node.right, x + 1, y + 1));
			}
		}

		List<List<Integer>> list = new ArrayList<>();

		for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
			list.add(new ArrayList<>());
			for (PriorityQueue<Integer> nodes : ys.values()) {
				while (!nodes.isEmpty()) {
					list.get(list.size() - 1).add(nodes.poll());
				}
			}

		}

		return list;
	}

	public ArrayList<Integer> printBottomViewBinaryTree(Node root) {

		ArrayList<Integer> ans = new ArrayList<>();
		if (root == null)
			return ans;
		Map<Integer, Integer> map = new HashMap<>();
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, root));
		while (!q.isEmpty()) {
			Pair temp = q.poll();
			int hd = temp.hd;
			map.put(hd, temp.node.data);
			if (temp.node.left != null) {
				q.add(new Pair(hd - 1, temp.node.left));
			}
			if (temp.node.right != null) {
				q.add(new Pair(hd + 1, temp.node.right));
			}
		}

		for (Map.Entry<Integer, Integer> m : map.entrySet()) {
			ans.add(m.getValue());
		}
		return ans;
	}

	public Node lcaBinaryTree(Node root, int p, int q) {

		if (root == null || root.data == p || root.data == q) {
			return root;
		}

		Node left = lcaBinaryTree(root.left, p, q);
		Node right = lcaBinaryTree(root.right, p, q);

		if (left == null) {
			return right;
		} else if (right == null) {
			return left;
		} else {
			return root;
		}

	}

	public Node lcaBinarySearchTree(Node root, int p, int q) {

		int min = Math.min(p, q);
		int max = Math.max(p, q);

		while (root != null) {
			if (min > root.data) {
				root = root.right;
			} else if (max < root.data) {
				root = root.left;
			} else {
				return root;
			}
		}
		return null;
	}

	public Node buildTree(int[] inorder, int[] postorder) {

		if (inorder == null || postorder == null || inorder.length != postorder.length) {
			return null;
		}

		HashMap<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i < inorder.length; i++) {
			hm.put(inorder[i], i);
		}

		return buildTreePostIn(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, hm);
	}

	public Node buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe,
			HashMap<Integer, Integer> hm) {

		if (is > ie || ps > pe)
			return null;

		Node root = createNewNode(postorder[pe]);
		int inRoot = hm.get(postorder[pe]);
		int numsLeft = inRoot - is;

		root.left = buildTreePostIn(inorder, is, inRoot - 1, postorder, ps, ps + numsLeft - 1, hm);

		root.right = buildTreePostIn(inorder, inRoot + 1, ie, postorder, ps + numsLeft, pe - 1, hm);

		return root;

	}

	public int distanceBetweenGivenNodes(Node root, Node left, Node right) {

		Node lca = null;

		if (isPresent(root, left) && isPresent(root, right)) {
			lca = lcaBinaryTree(root, left.data, right.data);
		} else {
			return Integer.MIN_VALUE;
		}

		return findLevel(lca, left, 0) + findLevel(lca, right, 0);

	}

	private boolean isPresent(Node root, Node node) {

		if (root == null)
			return false;

		if (root == node)
			return true;

		return isPresent(root.left, node) || isPresent(root.right, node);
	}

	private int findLevel(Node root, Node node, int level) {

		if (root == null)
			return Integer.MIN_VALUE;

		if (root == node)
			return level;

		int left = findLevel(root.left, node, level + 1);

		if (left != Integer.MIN_VALUE)
			return left;

		return findLevel(root.right, node, level + 1);

	}

	public List<Integer> rightViewBinaryTree(Node root) {
		List<Integer> result = new ArrayList<>();
		rightView(root, result, 0);
		return result;

	}

	private void rightView(Node root, List<Integer> result, int currDepth) {
		if (root == null) {
			return;
		}
		if (currDepth == result.size()) {
			result.add(root.data);
		}

		rightView(root.right, result, currDepth + 1);
		rightView(root.left, result, currDepth + 1);

	}

	/* Check if given nodes are cousins */

	/* Bottom up level order traversal */

	/* Iterative Pre-Order */

	/* Path Sum I, II, III Leetcode */

	/* Maximum Path Sum */

	/* Zig Zag Traversal */

	/* Iterative In Order */

	/* Serialize-Deserialize Binary Tree */

	/* Connect nodes on the same level binary tree */

	/* Check if n-ary trees are mirror image of each other */

	/* Check binary trees for mirror image */

	/* Convert a given tree to sum tree */

}

public class BinaryTreeApp {
//	public static void main(String[] args) {\
//
//		BinaryTree a = new BinaryTree();
//
//		Node root = a.createNewNode(2);
//		root.left = a.createNewNode(7);
//		root.right = a.createNewNode(5);
//		root.left.left = a.createNewNode(2);
//		root.left.right = a.createNewNode(6);
//		root.left.right.left = a.createNewNode(5);
//		root.left.right.right = a.createNewNode(11);
//		root.right.right = a.createNewNode(9);
//		root.right.right.left = a.createNewNode(4);
//	}

}
