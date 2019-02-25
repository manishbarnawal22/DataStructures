package com.sample.datastructure.linkedlist;

//Iterative way
public class MergeTwoLinkedListInSortedOrder1 {

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

	//Without Recursion
	Node mergeTwoListInSortedOrder(Node head1, Node head2)
	{
		Node result= new Node(0);
		Node finalList= result;
		
		while(head1!=null && head2!=null)
		{
			if(head1.data<head2.data)
			{
				result.next=head1;
				head1=head1.next;
			}	
			else
			{
				result.next=head2;
				head2=head2.next;
			}
			result=result.next;
		}
		
		result.next=(head1==null)?head2:head1;
		
		return finalList.next;
	}
	
	public static void main(String[] args) {
		MergeTwoLinkedListInSortedOrder1 list = new MergeTwoLinkedListInSortedOrder1();
		list.insert(10);
		list.insert(20);
		list.insert(35);
		list.insert(50);
		list.insert(70);
		
		MergeTwoLinkedListInSortedOrder1 list2 = new MergeTwoLinkedListInSortedOrder1();
		list2.insert(20);
		list2.insert(30);
		list2.insert(40);
		list2.insert(55);
		
		System.out.println("First list is:");
		list.printList(list.head);
		
		System.out.println("\nSecond list is:");
		list.printList(list2.head);
		
		System.out.println("\nAfter merging:");
		list.printList(list.mergeTwoListInSortedOrder(list.head, list2.head));
		
	}
	
}
