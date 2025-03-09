package com.bhambey.book.binarytrees;

import java.util.List;

public class RightViewBinaryTree {

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

		List<Integer> list = a.rightViewBinaryTree(root);

		for (Integer i : list) {
			System.out.println(i + " ");
		}

	}
}
