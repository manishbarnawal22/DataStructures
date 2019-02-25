package com.sample.datastructure.linkedlist;

import java.util.Hashtable;

public class IntersectionOfTwoSinglyLinkedList {

	private Node head;
	class Node
	{
		int data;
		Node next;
		
		Node(int data)
		{
			this.data=data;
		}
	}
		
		Node insert(int data)
		{
			Node newNode = new Node(data);
			if(head == null)
			{
				head=newNode;
				return head;
			}
			
			Node temp=head;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next=newNode;
			newNode.next=null;
			
			return head;
		}
		
		void printList(Node head)
		{
			Node temp=head;
			while(temp!=null)
			{
				System.out.print(temp.data+ " ");
				temp=temp.next;
			}
		}
		
		//using difference of the count of two linked list.
		//O(Max(m,n)) and auxiliary space: O(1)
		int findIntersectionNodeData(Node head1, Node head2)
		{
			Node temp1 = head1;
			Node temp2 = head2;
			
			int length1 = getLinkedListLength(head1);
			int length2=  getLinkedListLength(head2);
			
			int diff = length1-length2;
			int count=0;
			
			do{
				count++;
				temp1=temp1.next;
			}
			while(count!=diff);
			
			while(temp1.next!=null && temp2.next!=null )
			{
				if(temp1==temp2)
				{
					return temp1.data;
				}
				temp1=temp1.next;
				temp2=temp2.next;
			}
			return 0;
		}
		
		int findInterSectionPointUsingHashtable(Node head1, Node head2)
		{
			Node temp1 = head1;
			Node temp2=head2;
			Boolean isPresent=true;
			Hashtable<Integer, Boolean> lHashTable = new Hashtable<>();
			while(temp1!=null)
			{
					lHashTable.put(temp1.data, isPresent);
					temp1=temp1.next;
			}
			while(temp2!= null)
			{
				if(isPresent.equals(lHashTable.get(temp2.data)))
				{
					return temp2.data;
				}
				temp2=temp2.next;
			}
			
			return 0;
		}
		
		private int getLinkedListLength(Node head) {
			Node temp=head;
			int count=0;
			while(temp.next!=null)
			{
				count++;
				temp=temp.next;
			}
			return count;
		}

		public static void main(String[] args) {
			
			IntersectionOfTwoSinglyLinkedList list = new IntersectionOfTwoSinglyLinkedList();
			list.insert(3);
			list.insert(6);
			list.insert(9);
			list.insert(15);
			list.insert(30);
			list.insert(40);
			list.insert(50);
			
			System.out.println("First Linked List: ");
			list.printList(list.head);

			IntersectionOfTwoSinglyLinkedList list2 = new IntersectionOfTwoSinglyLinkedList();
			list2.insert(10);
			list2.insert(25);
			list2.insert(15);
			list2.insert(45);
			list2.insert(55);
			list2.head.next.next=list.head.next.next.next.next;
			
			System.out.println("\nSecond Linked List: ");
			list.printList(list2.head);
			
			System.out.println("\nThe Intersection data using difference of count nodes:");
			int intersectionData = list.findIntersectionNodeData(list.head, list2.head);
			System.out.println(intersectionData);
			
			System.out.println("\nThe Intersection data using hashtable visited nodes:");
			int intersectionData1 = list.findInterSectionPointUsingHashtable(list.head, list2.head);
			System.out.println(intersectionData1);
		}
		
}
