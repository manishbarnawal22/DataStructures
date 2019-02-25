package com.sample.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

/**
 * https://www.geeksforgeeks.org/level-order-tree-traversal/
 * 
 * @author Manish.Barnawal
 * 
 *         /* 1 2 3 4 5 7 6
 * 
 */
public class BinaryTreeTraversalProblems {

	public static void main(String[] args) {

		BinaryTree lBinaryTree = new BinaryTree();

		BinaryTree.Node root = lBinaryTree.new Node(1);
		BinaryTree.Node node2 = lBinaryTree.new Node(2);
		BinaryTree.Node node3 = lBinaryTree.new Node(3);
		BinaryTree.Node node4 = lBinaryTree.new Node(4);
		BinaryTree.Node node5 = lBinaryTree.new Node(5);
		BinaryTree.Node node6 = lBinaryTree.new Node(6);
		BinaryTree.Node node7 = lBinaryTree.new Node(7);

		root.left = node2;
		root.right = node3;
		node3.left = node7;
		node2.left = node4;
		node2.right = node5;
		node5.right = node6;
		System.out.println("The level order traversal is:");
		lBinaryTree.printLevelOrder(root);

		// This is the best one to remember.
		System.out.println("The level order traversal line by line is:");
		lBinaryTree.printLevelOrderLineByLine1(root);

		System.out.println("The binary tree left view is:");
		lBinaryTree.printLeftViewIterative(root);

		System.out.println("The binary tree left view using recursion is:");
		lBinaryTree.printLeftViewRecursion(root, 1);

		System.out.println("\nThe binary tree right view is:");
		lBinaryTree.printRightViewIterative(root);

		System.out.println("The binary tree right view using recursion is:");
		lBinaryTree.printRightViewRecursion(root, 1);

		int height = lBinaryTree.printHeightOfABinaryTree(root);
		System.out.println("The height of the binary tree is:" + height);
		
		int height1 = lBinaryTree.printHeightRecursively(root);
		System.out.println("The height of the binary tree recursively is:" + height1);

		System.out.println("******Program to find the mirror of the given binary tree.***************");
		// I have a below binary tree I have to create mirror of it.
		BinaryTree lBinaryTree1 = new BinaryTree();

		BinaryTree.Node root11 = lBinaryTree1.new Node(1);
		BinaryTree.Node node22 = lBinaryTree1.new Node(2);
		BinaryTree.Node node33 = lBinaryTree1.new Node(3);
		BinaryTree.Node node44 = lBinaryTree1.new Node(4);
		BinaryTree.Node node55 = lBinaryTree1.new Node(5);
		BinaryTree.Node node66 = lBinaryTree1.new Node(6);
		BinaryTree.Node node77 = lBinaryTree1.new Node(7);

		root11.left = node22;
		root11.right = node33;
		node33.left = node77;
		node22.left = node44;
		node22.right = node55;
		node55.right = node66;

		System.out.println("The binary tree given is as follows:");
		lBinaryTree1.printLevelOrderLineByLine1(root11);

		System.out.println("The mirror of the above binary tree using recursion is:");
		lBinaryTree1.mirrorViewRecursive(root11);
		System.out.println("The mirror of the tree using recursion is below:");
		lBinaryTree1.printLevelOrderLineByLine1(root11);

		lBinaryTree1.mirrorViewIterative(root11);
		System.out.println("The mirror of the above tree using iterative way is below:");
		lBinaryTree1.printLevelOrderLineByLine1(root11);

		System.out.println("******Program to find the mirror of the given binary tree ends here***************");

		System.out.println("*************The below tree is given. Find the vertical view.***********");
		BinaryTree lBinaryTree2 = new BinaryTree();

		BinaryTree.Node root110 = lBinaryTree2.new Node(1);
		BinaryTree.Node node220 = lBinaryTree1.new Node(2);
		BinaryTree.Node node330 = lBinaryTree2.new Node(3);
		BinaryTree.Node node440 = lBinaryTree2.new Node(4);
		BinaryTree.Node node550 = lBinaryTree2.new Node(5);
		BinaryTree.Node node660 = lBinaryTree2.new Node(6);
		BinaryTree.Node node770 = lBinaryTree2.new Node(7);

		root110.left = node220;
		root110.right = node330;
		node330.left = node770;
		node220.left = node440;
		node220.right = node550;
		node550.right = node660;

		System.out.println("The vertical Order is:");
		lBinaryTree2.printVerticalView(root110);

	}
}
