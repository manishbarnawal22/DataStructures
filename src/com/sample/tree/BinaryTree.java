package com.sample.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

class BinaryTree {
	
	public class Node {
		public Node left;
		public Node right;
		public int info;

		Node(int info) {
			this.info = info;
		}
	}

	public Node insertNodeAtLast(Node rootNode, int info) {
		if (rootNode == null) {
			rootNode = new Node(info);
		} else {
			Queue<Node> queue = new LinkedList<>();
			queue.add(rootNode);
			while (!queue.isEmpty()) {
				Node tempNode = queue.poll();
				if (tempNode.left != null && tempNode.right != null) {
					queue.add(tempNode.left);
					queue.add(tempNode.right);
				} else {
					if (tempNode.left == null) {
						tempNode.left = new Node(info);
					} else {
						tempNode.right = new Node(info);
					}
					break;
				}
			}
		}
		return rootNode;
	}

	
	/***
	 * 
	 * Algo:
	 * 
	 * 1) Create an empty queue q 2) temp_node = root /*start from root 3) Loop
	 * while temp_node is not NULL a) print temp_node->data. b) Enqueue temp_node’s
	 * children (first left then right children) to q c) Dequeue a node from q and
	 * assign it’s value to temp_node
	 * 
	 * @param root
	 */
	public void printLevelOrder(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();
			System.out.println(tempNode.info + " ");

			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}

	// https://www.youtube.com/watch?v=PQKkr036wRc Vivekananda
	// This algo = Level Order Traversal + Map or HashTable to store key and values.
	/*
	 * Step 1: Enqueue root. Step 2: update HD for root as zero. Step 3: Add HD in
	 * Map as key and root as value.
	 * 
	 * 
	 */
	// To print vertical order we need to maintain a map where we will put the
	// horizontal distance of every node
	// as key and value will be the another list of nodes with the same key of
	// horizontal distance.

	public void printVerticalView(Node root110) {

		if (root110 == null) {
			return;
		}

		Queue<Node> queue = new LinkedList<Node>();
		Queue<Integer> distanceQueue = new LinkedList<Integer>();

		TreeMap<Integer, LinkedList<Node>> distanceMap = new TreeMap<>();

		distanceQueue.add(0);
		queue.add(root110);

		while (!queue.isEmpty()) {

			Node tempNode = queue.poll();
			int distance = distanceQueue.poll();

			if (distanceMap.get(distance) == null) {
				distanceMap.put(distance, new LinkedList<Node>());
			}

			distanceMap.get(distance).add(tempNode);

			if (tempNode.left != null) {
				distanceQueue.add(distance - 1);
				queue.add(tempNode.left);
			}

			if (tempNode.right != null) {
				distanceQueue.add(distance + 1);
				queue.add(tempNode.right);
			}
		}

		printVerticalOrder(distanceMap);
	}

	private void printVerticalOrder(TreeMap<Integer, LinkedList<Node>> lMap) {

		for (int key : lMap.keySet()) {
			System.out.print("lMap.get(key):" + key + " ");
			for (Node node : lMap.get(key))
				System.out.print(node.info + " ");
			System.out.println("");
		}
	}

	public void mirrorViewIterative(Node root11) {

		Queue<Node> queue = new LinkedList<>();
		queue.add(root11);

		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();

			// swap left and right of tempNode
			Node temp = tempNode.left;
			tempNode.left = tempNode.right;
			tempNode.right = temp;

			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}

	}

	public void mirrorViewRecursive(Node root11) {

		if (root11 == null) {
			return;
		}
		mirrorViewRecursive(root11.left);
		mirrorViewRecursive(root11.right);

		// swap the left and right
		Node temp = root11.left;
		root11.left = root11.right;
		root11.right = temp;
	}

	public void printLevelOrderLineByLine1(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);

		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();

			if (tempNode != null) {
				if (tempNode.left != null) {
					queue.add(tempNode.left);
				}
				if (tempNode.right != null) {
					queue.add(tempNode.right);
				}
				System.out.print(tempNode.info + " ");
			} else {
				System.out.println();
				if (!queue.isEmpty()) {
					queue.add(null);
				}
			}
		}
	}

	int printHeightOfABinaryTree(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);

		int height = 0;
		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();

			if (tempNode != null) {
				if (tempNode.left != null) {
					queue.add(tempNode.left);
				}
				if (tempNode.right != null) {
					queue.add(tempNode.right);
				}
			} else {
				System.out.println();
				height++;
				if (!queue.isEmpty()) {
					queue.add(null);
				}
			}
		}
		return height;
	}
	
	int printHeightRecursively(Node root)
	{
		if(root == null)
		{
			return 0;
		}
		int height = Math.max(printHeightRecursively(root.left)+1, printHeightRecursively(root.right)+1);
		
		return height;
	}

	// this has just a slight change in print statement of above method.
	void printLeftViewIterative(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		System.out.print(root.info + " ");

		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();

			if (tempNode != null) {
				if (tempNode.left != null) {
					queue.add(tempNode.left);
				}
				if (tempNode.right != null) {
					queue.add(tempNode.right);
				}
			} else {
				System.out.println();
				if (!queue.isEmpty()) {
					System.out.print(queue.peek().info + " ");
					queue.add(null);
				}
			}
		}
	}

	static int max_level = 0;

	void printLeftViewRecursion(Node node, int level) {

		// Base Case
		if (node == null)
			return;

		// If this is the first node of its level
		if (max_level < level) {
			System.out.print(" " + node.info);
			max_level = level;
		}

		// Recur for left and right subtrees
		printLeftViewRecursion(node.left, level + 1);
		printLeftViewRecursion(node.right, level + 1);
	}

	// same as above just the print change we print the last element of the queue at
	// every level.
	void printRightViewIterative(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		System.out.print(root.info + " ");

		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();

			if (tempNode != null) {
				if (tempNode.left != null) {
					queue.add(tempNode.left);
				}
				if (tempNode.right != null) {
					queue.add(tempNode.right);
				}
			} else {
				System.out.println();
				if (!queue.isEmpty()) {
					printLastElementOfTheQueue(queue);
					queue.add(null);
				}
			}
		}
	}

	static int max_level1 = 0;

	void printRightViewRecursion(Node node, int level) {

		// Base Case
		if (node == null)
			return;

		// If this is the first node of its level
		if (max_level1 < level) {
			System.out.print(" " + node.info);
			max_level1 = level;
		}

		// Recur for left and right subtrees
		printRightViewRecursion(node.right, level + 1);
		printRightViewRecursion(node.left, level + 1);
	}

	private void printLastElementOfTheQueue(Queue<Node> queue) {
		LinkedList<Node> list = (LinkedList<Node>) queue;
		System.out.print(((Node) list.getLast()).info + " ");
	}
}
