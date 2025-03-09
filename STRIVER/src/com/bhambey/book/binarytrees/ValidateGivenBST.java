package com.bhambey.book.binarytrees;

public class ValidateGivenBST {

	public static void main(String[] args) {

		BinaryTree a = new BinaryTree();
		Node root = null;

		root = a.insert(root, 8);
		root = a.insert(root, 3);
		root = a.insert(root, 6);
		root = a.insert(root, 10);
		root = a.insert(root, 4);
		root = a.insert(root, 7);
		root = a.insert(root, 1);
		root = a.insert(root, 14);
		root = a.insert(root, 13);

		if (a.validateGivenBST(root, Long.MIN_VALUE, Long.MAX_VALUE)) {
			System.out.println("Given tree is a BST");
		} else {
			System.out.println("Given tree is not a BST");
		}

	}

}
