package com.sample.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import com.sample.tree.BinaryTree.Node;

import java.util.Queue;
import java.util.TreeMap;

public class TopBottomVerticalViewOfBinaryTree {

	public static void main(String[] args) {

		NodeForView lRootNode = null;
		TopBottomVerticalViewOfBinaryTree lTopViewOfBinaryTree = new TopBottomVerticalViewOfBinaryTree();
		lRootNode = lTopViewOfBinaryTree.insertNodeAtLast(lRootNode, 10);
		lTopViewOfBinaryTree.insertNodeAtLast(lRootNode, 20);
		lTopViewOfBinaryTree.insertNodeAtLast(lRootNode, 30);
		lTopViewOfBinaryTree.insertNodeAtLast(lRootNode, 40);
		lTopViewOfBinaryTree.insertNodeAtLast(lRootNode, 50);
		lTopViewOfBinaryTree.insertNodeAtLast(lRootNode, 60);
		lTopViewOfBinaryTree.insertNodeAtLast(lRootNode, 70);

		System.out.println("The tree created is:");
		new TopBottomVerticalViewOfBinaryTree().printLevelOrderLineByLine1(lRootNode);
		
		
		System.out.println("\nThe top view of the tree is:");
		Map<Integer, NodeForView> lMap = printTopView(lRootNode);
		for (Map.Entry<Integer, NodeForView> element : lMap.entrySet()) {
			System.out.print(((NodeForView) element.getValue()).getData() + " ");
		}

		System.out.println();
		System.out.println("\nThe vertical view of the tree is:");
		Map<Integer, String> lMap1 = printVerticalView(lRootNode);
		for (Entry<Integer, String> element : lMap1.entrySet()) {
			System.out.println((String) element.getValue() + " ");
		}

		System.out.println();
		System.out.println("The bottom view of the tree is:");
		Map<Integer, NodeForView> lMap2 = printBottomView(lRootNode);
		for (Entry<Integer, NodeForView> element : lMap2.entrySet()) {
			System.out.print(element.getValue().data + " ");
		}
	}

	/**
	 * 
	 * Prepare the map with only one entry for each new key i.e. level.
	 * And those entries will become the top view of the binary tree. 
	 * like :
	 * Key	Nodes
	 * 0  - 10
	 * -1 - 20
	 * -2 - 40
	 * +1 - 30
	 * +2 - 70
	 * 
	 * o/p: 40 20 10 30 70 in sorted order as we are using TreeMap.
	 * 
	 * 
	 * @param rootNode
	 * @return
	 */
	public static Map<Integer, NodeForView> printTopView(NodeForView rootNode) {

		Map<Integer, NodeForView> map = new TreeMap<Integer, NodeForView>();

		if (rootNode == null)
			return map;

		Queue<NodeForView> queue = new LinkedList<NodeForView>();
		queue.add(rootNode);

		while (!queue.isEmpty()) {
			NodeForView tempNode = (NodeForView) queue.poll();

			int currentLevel = tempNode.getLevel();
			if (map.get(tempNode.getLevel()) == null) {
				map.put(tempNode.getLevel(), tempNode);
			}

			if (tempNode.getLeftNode() != null) {
				tempNode.getLeftNode().setLevel(currentLevel - 1);
				queue.add(tempNode.getLeftNode());
			}

			if (tempNode.getRightNode() != null) {
				tempNode.getRightNode().setLevel(currentLevel + 1);
				queue.add(tempNode.getRightNode());
			}
		}
		return map;

	}

	/**
	 * 
	 * In the map put all the keys and override so that the last value with the same key will remain which will
	 * be the part of bottomview for that level as key. 
	 * like :
	 * * Key	Nodes
	 * 0  - 60
	 * -1 - 20
	 * -2 - 40
	 * +1 - 30
	 * +2 - 70
	 * 
	 * o/p: 40 20 60 30 70 in sorted order it will come as we are using TreeMap.
	 * 
	 */
	private static Map<Integer, NodeForView> printBottomView(NodeForView rootNode) {

		Map<Integer, NodeForView> map = new TreeMap<Integer, NodeForView>();
		if (rootNode == null)
			return map;

		Queue<NodeForView> queue = new LinkedList<NodeForView>();
		queue.add(rootNode);

		while (!queue.isEmpty()) {
			NodeForView tempNode = (NodeForView) queue.poll();

			int currentLevel = tempNode.getLevel();
			map.put(currentLevel, tempNode);

			if (tempNode.getLeftNode() != null) {
				tempNode.getLeftNode().setLevel(currentLevel - 1);
				queue.add(tempNode.getLeftNode());
			}

			if (tempNode.getRightNode() != null) {
				tempNode.getRightNode().setLevel(currentLevel + 1);
				queue.add(tempNode.getRightNode());
			}
		}
		return map;

	}

	/**
	 * For vertical view of binary tree we need to maintain all the nodes for each key as an entry.
	 * like :
	 * Key	Nodes
	 * 0  - 10 50 60
	 * -1 - 20
	 * -2 - 40
	 * +1 - 30
	 * +2 - 70
	 * 
	 * 
	 * 
	 * @param rootNode
	 * @return
	 */
	public static Map<Integer, String> printVerticalView(NodeForView rootNode) {

		Map<Integer, String> map = new TreeMap<Integer, String>();

		if (rootNode == null)
			return map;

		Queue<NodeForView> queue = new LinkedList<NodeForView>();
		queue.add(rootNode);

		while (!queue.isEmpty()) {
			NodeForView tempNode = (NodeForView) queue.poll();

			int currentLevel = tempNode.getLevel();
			if (map.get(tempNode.getLevel()) != null) {
				map.put(tempNode.getLevel(),
						map.get(tempNode.getLevel()) + "," + tempNode.getData());
			} else {
				map.put(tempNode.getLevel(), String.valueOf(tempNode.getData()));
			}

			if (tempNode.getLeftNode() != null) {
				tempNode.getLeftNode().setLevel(currentLevel - 1);
				queue.add(tempNode.getLeftNode());
			}

			if (tempNode.getRightNode() != null) {
				tempNode.getRightNode().setLevel(currentLevel + 1);
				queue.add(tempNode.getRightNode());
			}
		}
		return map;

	}

	public NodeForView insertNodeAtLast(NodeForView rootNode, int info) {
		if (rootNode == null) {
			rootNode = new NodeForView(info);
		} else {
			Queue<NodeForView> queue = new LinkedList<>();
			queue.add(rootNode);
			while (!queue.isEmpty()) {
				NodeForView tempNode = queue.poll();
				if (tempNode.getLeftNode() != null && tempNode.getRightNode() != null) {
					queue.add(tempNode.getLeftNode());
					queue.add(tempNode.getRightNode());
				} else {
					if (tempNode.getLeftNode() == null) {
						tempNode.setLeftNode(new NodeForView(info));
					} else {
						tempNode.setRightNode(new NodeForView(info));
					}
					break;
				}
			}
		}
		return rootNode;
	}
	
	public void printLevelOrderLineByLine1(NodeForView root) {
		Queue<NodeForView> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);

		while (!queue.isEmpty()) {
			NodeForView tempNode = queue.poll();

			if (tempNode != null) {
				if (tempNode.getLeftNode() != null) {
					queue.add(tempNode.getLeftNode());
				}
				if (tempNode.getRightNode() != null) {
					queue.add(tempNode.getRightNode());
				}
				System.out.print(tempNode.data + " ");
			} else {
				System.out.println();
				if (!queue.isEmpty()) {
					queue.add(null);
				}
			}
		}
	}

	class NodeForView {

		private int data;
		private NodeForView leftNode;
		private NodeForView rightNode;
		private int level;

		public NodeForView(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public NodeForView getLeftNode() {
			return leftNode;
		}

		public void setLeftNode(NodeForView leftNode) {
			this.leftNode = leftNode;
		}

		public NodeForView getRightNode() {
			return rightNode;
		}

		public void setRightNode(NodeForView rightNode) {
			this.rightNode = rightNode;
		}

		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}

	}

}
