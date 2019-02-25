package com.sample.datastructure.linkedlist;

public class PhysicallyReverseALinkedList
{
    private Node head;
    class Node
    {
        private int data;
        private Node next;
        
        Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }
    
    void insert(int data)
    {
        Node temp=head;
        Node newNode = new Node(data);
        if(head == null)
        {
            head=newNode;
            return;
        }
        while(temp.next!= null)
        {
            temp=temp.next;
        }
        temp.next=newNode;
        newNode.next=null;
        
        return;
    }
    
    //Time O(n) and Space O(1)
    Node reverse(Node head)
    {
        Node curr=head;
        Node prev=null;
        Node next = null;
        
        while(curr!=null)
        {
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
        
        return head;
    }
    
    void printList(Node head)
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print( temp.data+" " );
            temp = temp.next;
        }
    }
    
    public static void main( String[] args )
    {
        PhysicallyReverseALinkedList list = new PhysicallyReverseALinkedList();
        list.insert( 10 );
        list.insert( 20 );
        list.insert( 40 );
        list.insert( 60 );
        
        System.out.println( "The List is:" );
        list.printList( list.head );
        
        System.out.println( "\nThe reverse list is:" );
       
        list.printList( list.reverse( list.head ));
    }
}
