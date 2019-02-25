package com.sample.datastructure.linkedlist;

import com.sample.datastructure.linkedlist.FindMiddleOfLinkedList.Node;

public class DisplayLinkedListFromEnd {

	private Node head;

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	void insert(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			return;
		}

		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = newNode;
		newNode.next = null;
	}
	
	void printList(Node head)
	{
		Node temp = head;
		while (temp!= null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
	
	//must need to move head till end and then start printing.
	//Time : O(n) and Space : O(n) for stack.
	void printReverseRecursively(Node head)
	{
		if (head == null) {
			return;
		}
		head=head.next;
		printReverseRecursively(head);
		System.out.print(head.data + " ");

	}
	
	public static void main(String[] args) {
		DisplayLinkedListFromEnd list = new DisplayLinkedListFromEnd();
		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);
		
		System.out.println("The list is:");
		list.printList(list.head);
		
		System.out.println("\nThe reverse of the list is:");
		list.printReverseRecursively(list.head);
	}
	
}
