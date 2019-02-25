package com.sample.tree;

import com.sample.tree.BinaryTree.Node;

//E.g
/*		
			1

	  2		    3
	4   5      6     7
20       30        35


 Print the boundary as 	//Final output: 1 2 4 20 30 6 35 7 3
*/
public class PrintBoundaryOfABinaryTree {

	public static void main(String[] args) {

		final BinaryTree lBinaryTree = new BinaryTree();
		BinaryTree.Node root = lBinaryTree.new Node(1);
		BinaryTree.Node l1 = lBinaryTree.new Node(2);
		BinaryTree.Node r1 = lBinaryTree.new Node(3);
		BinaryTree.Node ll2 = lBinaryTree.new Node(4);
		BinaryTree.Node lr2 = lBinaryTree.new Node(5);
		BinaryTree.Node rl2 = lBinaryTree.new Node(6);
		BinaryTree.Node rr2 = lBinaryTree.new Node(7);

		root.left = l1;
		root.right = r1;
		l1.left = ll2;
		l1.right = lr2;
		r1.left = rl2;
		r1.right = rr2;

		BinaryTree.Node ll3 = lBinaryTree.new Node(20);
		BinaryTree.Node lrr3 = lBinaryTree.new Node(30);
		BinaryTree.Node rrl3 = lBinaryTree.new Node(35);

		ll2.left = ll3;
		lr2.right = lrr3;
		rr2.left = rrl3;

		System.out.println("The boundary view of the binary tree is:");
		boundaryTraversal(root);
	}

	// https://articles.leetcode.com/print-edge-nodes-boundary-of-binary/
	private static void boundaryTraversal(Node root) {
		if (root != null) {
			System.out.print(root.info + " ");
		}

		// First print in one recursive loop 1 2 4 except the leaf node.
		printLeftBoundaryInTopDownOrder(root.left);

		// Second process the left subset of the main root node 1, print the leaf node
		// 20 by going till
		// the left leaf node & right leaf node 30 using recursion
		printLeafNodesInLeftToRightOrder(root.left);

		// Third process the right subset of the main root node 1. And print the leaf
		// nodes from left to right. i.e 6 35
		printLeafNodesInLeftToRightOrder(root.right);

		// Fourth print the bootom up order other then the leaf node. i.e 7 3
		printRightBoundaryInBottomUpOrder(root.right);

		// Final output: 1 2 4 20 30 6 35 7 3
	}

	private static void printLeftBoundaryInTopDownOrder(Node root) {
		if (root == null || isLeafNode(root)) {
			return;
		}

		System.out.print(root.info + " ");

		printLeftBoundaryInTopDownOrder(root.left);
	}

	private static void printLeafNodesInLeftToRightOrder(Node root) {
		if (root == null) {
			return;
		}

		if (isLeafNode(root)) {
			System.out.print(root.info + " ");
			return;
		}

		printLeafNodesInLeftToRightOrder(root.left);

		printLeafNodesInLeftToRightOrder(root.right);
	}

	private static void printRightBoundaryInBottomUpOrder(Node root) {
		if (root == null || isLeafNode(root)) {
			return;
		}

		printRightBoundaryInBottomUpOrder(root.right);

		System.out.print(root.info + " ");
	}

	private static boolean isLeafNode(Node root) {
		return root.left == null && root.right == null;
	}

}