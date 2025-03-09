package com.bhambey.book.binarytrees;

public class DistanceKFromLeafNodes {

	public static void main(String[] args) {
		BinaryTree a = new BinaryTree();

		Node root = a.createNewNode(8);
		root.left = a.createNewNode(7);
		root.right = a.createNewNode(5);
		root.left.left = a.createNewNode(2);
		root.left.right = a.createNewNode(6);
		root.left.right.left = a.createNewNode(3);
		root.left.right.right = a.createNewNode(11);
		root.right.right = a.createNewNode(9);
		root.right.right.left = a.createNewNode(4);

		int k = 2;
		int[] arr = new int[1000];
		boolean[] visited = new boolean[1000];
		int count = 0;

		a.distanceKFromLeafNodes(root, k, arr, visited, count);

	}

}
