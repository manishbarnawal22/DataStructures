package com.sample.datastructure.linkedlist;

public class CreateLinkListAndDisplayInReverse {

	Node head;
	class Node
	{
		int info;
		Node next;
		
		Node(int info)
		{
			this.info = info;
			this.next=null;
		}
	}
	
	Node createLinkList(int info)
	{
		Node node = new Node(info);
		
		if(head == null)
		{
			head = node;
			node.next = null;
			return head;
		}
		
		Node temp = head;
		while(temp.next!= null)
		{
			temp = temp.next;
		}
		temp.next = node;
		
		return head;
	}
	
	void printLinkedList(Node head){
		Node temp = head;
		while(temp!= null)
		{
			System.out.println(temp.info);
			temp = temp.next;
		}
	}
	
	Node printReverseRecursively(Node head)
	{
		if(head == null)
		{
			return head;
		}
		
		Node node = printReverseRecursively(head.next);
		System.out.println(head.info);
		
		return node;
	}

	public static void main(String[] args) {
		
		CreateLinkListAndDisplayInReverse list = new CreateLinkListAndDisplayInReverse();
		list.createLinkList(2);
		list.createLinkList(4);
		list.createLinkList(5);
		
		System.out.println("The linked list is:");
		list.printLinkedList(list.head);
		
		System.out.println("The reverse of the linked list is:");
		list.printReverseRecursively(list.head);
	}
	
}


