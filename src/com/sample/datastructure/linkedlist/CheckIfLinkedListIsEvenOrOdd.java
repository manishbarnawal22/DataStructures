package com.sample.datastructure.linkedlist;

public class CheckIfLinkedListIsEvenOrOdd {

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
	
	//move pointer 2 nodes at a time. if temp is null then even else temp.next is null
	//then it is odd
	//O(n/2)=O(n) and space : O(1)
	void checkIfListIsEVenOrOdd(Node head)
	{
		Node temp=head;
		while(temp!=null && temp.next!= null )
		{
			temp=temp.next.next;
		}
		if(temp==null)
		{
			System.out.println("The list is Even");
		}
		else
			System.out.println("The list is odd.");
	}
	
	public static void main(String[] args) {
		CheckIfLinkedListIsEvenOrOdd list = new CheckIfLinkedListIsEvenOrOdd();
		list.insert(10);
		list.insert(20);
		list.insert(30);
		//list.insert(40);
		
		System.out.println("The list is:");
		list.printList(list.head);
		
		System.out.println("\nIs given list Odd or even:");
		list.checkIfListIsEVenOrOdd(list.head);
		
	}
}
