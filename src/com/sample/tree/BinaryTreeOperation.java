package com.sample.tree;

import com.sample.tree.BinaryTree.Node;

public class BinaryTreeOperation {

	public static void main(String[] args) {

		BinaryTree lBinaryTree = new BinaryTree();
		
		Node rootNode = null;
		rootNode = lBinaryTree.insertNodeAtLast(rootNode, 10);
		lBinaryTree.insertNodeAtLast(rootNode, 20);
		lBinaryTree.insertNodeAtLast(rootNode, 30);
		lBinaryTree.insertNodeAtLast(rootNode, 40);
		lBinaryTree.insertNodeAtLast(rootNode, 50);
		lBinaryTree.insertNodeAtLast(rootNode, 60);
		lBinaryTree.insertNodeAtLast(rootNode, 70);

		System.out.println("\nThe new tree created is like below using level order traversal line by line.");
		lBinaryTree.printLevelOrderLineByLine1(rootNode);
	}
}
