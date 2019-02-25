package com.sample.tree;

import java.util.Queue;

import com.sample.datastructure.linkedlist.LinkedList;

public class BSTreeMain {
	public static void main(String args[]) {
		BSTree tree = new BSTree();

		BSTreeNode head = null;
		head = tree.addNode1(head, 9);
		head = tree.addNode1(head, 7);
		head = tree.addNode1(head, 10);
		head = tree.addNode1(head, 5);
		head = tree.addNode1(head, 6);
		head = tree.addNode1(head, 8);
		head = tree.addNode1(head, 11);
		head = tree.addNode1(head, 2);
		head = tree.addNode1(head, 1);

		tree.preOrderTraverse(head);

		/*int key = 9;
		System.out.println("\nFind Node:"+key);
		Node node = tree.findNode(head, key);
		System.out.println(node!=null?"Node key found:" + node.key:"Node key "+key+" doesnot exist.");*/
		
		Integer height = getHeightOfATreeWithRecursion(head);
		System.out.println("\nThe height of the tree is:"+height);
		
		Integer heightWithoutRecursion = getHeightOfATreeWithRecursion(head);
		System.out.println("\nThe height of the tree without recursion is:"+heightWithoutRecursion);
	}

	private static Integer getHeightOfATreeWithRecursion(BSTreeNode head) {

		if (head == null) {
			return 0;
		}

		int leftHeight = getHeightOfATreeWithRecursion(head.leftChild);
		int rightHeight = getHeightOfATreeWithRecursion(head.rightChild);

		// do Math.max(getHeightOfATree(head.leftChild),
		// getHeightOfATree(head.rightChild))+1; or do the below if else
		
		int h;
		if (leftHeight > rightHeight) {
			h = 1 + leftHeight;
		} else {
			h = 1 + rightHeight;
		}

		return h;
	}
	
	private static Integer findHeightOfATreeWithoutRecursion(BSTreeNode head)
	{
		Queue q = (Queue) new LinkedList();
		q.add(head);
		int height = 0;
		
		while(true)
		{
			int indexCount = q.size();
			if(indexCount == 0)
			{
				return height;
			}
			height ++;
			
			while(indexCount > 0)
			{
				BSTreeNode node = (BSTreeNode) q.peek();
				q.poll();
				if(node.leftChild != null)
				{
					q.add(node.leftChild);
				}
				if(node.rightChild != null)
				{
					q.add(node.rightChild);
				}
				indexCount--;
			}
		}
	}
}

class BSTreeNode {
	Integer key;
	String name;

	BSTreeNode leftChild;
	BSTreeNode rightChild;

	BSTreeNode(Integer key) {
		this.key = key;
	}
}

class BSTree {
	BSTreeNode root;

	public BSTreeNode addNode1(BSTreeNode head, int data) {
		BSTreeNode tempHead = head;
		BSTreeNode n = new BSTreeNode(data);
		if (head == null) {
			head = n;
			return head;
		}
		BSTreeNode parent = null;
		while (head != null) {
			parent = head;
			if (data > head.key) {
				head = head.rightChild;
			} else {
				head = head.leftChild;
			}
		}
		if (data > parent.key) {
			parent.rightChild = n;
		} else {
			parent.leftChild = n;
		}
		return tempHead;
	}

	public void preOrderTraverse(BSTreeNode root) {
		if (root != null) {
			System.out.print(root.key + " ");
			preOrderTraverse(root.leftChild);
			preOrderTraverse(root.rightChild);
		}
	}

	public BSTreeNode findNode(BSTreeNode root, Integer key) {
		BSTreeNode currentNode = root;

		while (currentNode.key != key) {
			if (key < currentNode.key) {
				currentNode = currentNode.leftChild;
			} else {
				currentNode = currentNode.rightChild;
			}

			if (currentNode == null) {
				return null;
			}
		}
		return currentNode;
	}

	/*
	 * public void addNode( Integer key ) { Node newNode = new Node( key ); if(
	 * root == null ) { root = newNode; } else { Node currentNode = root;
	 * 
	 * Node parent; while( true ) { parent = currentNode; if( key <
	 * currentNode.key ) { currentNode = currentNode.leftChild; if( currentNode
	 * == null ) { parent.leftChild = newNode; return; } } else { currentNode =
	 * currentNode.rightChild; if( currentNode == null ) { parent.rightChild =
	 * newNode; return; } } } } }
	 */

}
