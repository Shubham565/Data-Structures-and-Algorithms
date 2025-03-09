package com.bhambey.book.binarytrees;

public class ConstructFromInorderPostorder {

	public static void main(String[] args) {

		BinaryTree a = new BinaryTree();

		int[] inorder = new int[] { 2, 7, 3, 6, 11, 8, 5, 4, 9 };
		int[] postorder = new int[] { 2, 3, 11, 6, 7, 4, 9, 5, 8 };

		Node node = a.buildTree(inorder, postorder);

		a.InOrderIterative(node);

	}

}
