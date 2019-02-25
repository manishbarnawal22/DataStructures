package com.sample.tree;

import java.util.LinkedList;

//https://www.ideserve.co.in/learn/left-view-of-a-binary-tree
public class LeftViewOfBinaryTree {

	class QueueNode {
		TreeNode node;
		int level;

		QueueNode(TreeNode node, int level) {
			this.node = node;
			this.level = level;
		}
	}

	class TreeNode {
		TreeNode left;
		TreeNode right;
		int info;

		public TreeNode(int info) {
			this.info = info;
		}
	}

	TreeNode root;

	TreeNode createTree() {
		this.root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);

/*				1
		2					3
	4		5			7
				6							*/
		root.left = node2;
		root.right = node3;
		node3.left = node7;
		node2.left = node4;
		node2.right = node5;
		node5.right = node6;

		return root;
	}

	public void printLeftViewLevelOrder(TreeNode currentNode) {
		
		int maxLevelSoFar = -1;
		if (currentNode == null)
			return;

		LinkedList<QueueNode> queue = new LinkedList<>();

		queue.add(new QueueNode(currentNode, 0));

		while (!queue.isEmpty()) {
			QueueNode queueEntry = queue.remove();
			if (queueEntry.level > maxLevelSoFar) {
				maxLevelSoFar = queueEntry.level;
				System.out.println(queueEntry.node.info);
			}

			if (queueEntry.node.left != null)
				queue.add(new QueueNode(queueEntry.node.left, queueEntry.level + 1));

			if (queueEntry.node.right != null)
				queue.add(new QueueNode(queueEntry.node.right, queueEntry.level + 1));
		}

	}

	public static void main(String[] args) {
		LeftViewOfBinaryTree tree = new LeftViewOfBinaryTree();

		tree.createTree();

		tree.printLeftViewLevelOrder(tree.root);
	}

}
