package com.sample.datastructure.linkedlist;

public class FindMiddleOfLinkedList {

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
	
	//Time: O(n)+O(n)=O(n) & Space: O(1)
	int findMiddleElement(Node head)
	{
		Node temp=head;
		int count = 0;
		while(temp!=null)
		{
			count++;
			temp=temp.next;
		}
		System.out.println("\nThe count is:"+count);
		Node temp1=head;
		if(count%2 == 0)
		{
			for(int i=1;i<=count/2;i++)
			{
				if(i==count/2)
				{
					System.out.println(temp1.data+"and "+temp1.next.data+ " are the middle node for the even list");
				}
				temp1=temp1.next;
			}
		}
		else
		{
			for(int i=1;i<=count/2;i++)
			{
				if(i==count/2)
				{
					System.out.println(temp1.next.data+ " is the middle node for the odd list");
				}
				temp1=temp1.next;
			}
		}
		
		return 0;
	}
	
	//efficient way Time: O(n) and space : O(1)
	//move one pointer one step and other pointer double the speed of first pointer
	int findMiddleInOneScan(Node head)
	{
		Node slow_p=head;
		Node fast_p=head;
		
		while(slow_p!=null  && fast_p!=null && fast_p.next!=null)
		{
			slow_p=slow_p.next;
			fast_p=fast_p.next.next;
		}
		return slow_p.data;
	}
	
	//same as above findMiddleInOneScan()
	private int findMiddle(Node head) {
		Node ptr1x,ptr2x;
		ptr1x=ptr2x=head;

		int i=0;
		while(ptr1x.next!=null)
		{
			if(i==0)
			{
				ptr1x=ptr1x.next;
				i=1;
			}
			else if(i==1)
			{
				ptr1x=ptr1x.next;
				ptr2x=ptr2x.next;
				i=0;
			}
		}
		
		return ptr2x.data;
	}
	
	public static void main(String[] args) {
		
		FindMiddleOfLinkedList list = new FindMiddleOfLinkedList();
		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);
		list.insert(50);
		list.insert(60);
		
		System.out.println("The list is:");
		list.printList(list.head);
		
		int middleNode = list.findMiddleElement(list.head);
		
		int middleNodeInOneScan= list.findMiddleInOneScan(list.head);
		System.out.println("The middle node found in one scan:"+middleNodeInOneScan);
		
		
		int middNode = list.findMiddle(list.head);
		System.out.println("The middle:"+middNode);
	}

	
}
