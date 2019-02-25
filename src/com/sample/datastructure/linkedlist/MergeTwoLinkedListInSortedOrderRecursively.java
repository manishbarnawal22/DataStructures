package com.sample.datastructure.linkedlist;

//Recursive way
public class MergeTwoLinkedListInSortedOrderRecursively {

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

	Node mergeTwoListInSortedOrder(Node head1, Node head2)
	{
		if(head1==null)
		{
			return head2;
		}
		if(head2==null)
		{
			return head1;
		}
		Node result=new Node(0);
		if(head1.data<=head2.data)
		{
			result=head1;
			result.next=mergeTwoListInSortedOrder(head1.next,head2);
		}
		else
		{
			result=head2;
			result.next=mergeTwoListInSortedOrder(head2.next, head1);
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
		MergeTwoLinkedListInSortedOrderRecursively list = new MergeTwoLinkedListInSortedOrderRecursively();
		list.insert(10);
		list.insert(20);
		list.insert(35);
		list.insert(50);
		list.insert(70);
		
		MergeTwoLinkedListInSortedOrderRecursively list2 = new MergeTwoLinkedListInSortedOrderRecursively();
		list2.insert(20);
		list2.insert(30);
		list2.insert(40);
		list2.insert(55);
		
		System.out.println("First list is:");
		list.printList(list.head);
		
		System.out.println("\nSecond list is:");
		list.printList(list2.head);
		
		System.out.println("After merging:");
		list.printList(list.mergeTwoListInSortedOrder(list.head, list2.head));
		
	}
	
}
