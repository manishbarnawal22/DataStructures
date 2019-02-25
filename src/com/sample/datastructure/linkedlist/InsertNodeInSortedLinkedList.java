package com.sample.datastructure.linkedlist;

import com.sample.datastructure.linkedlist.CheckLinkedListHavingLoop.Node;

public class InsertNodeInSortedLinkedList
{
    private Node head;

    class Node
    {
        int data;
        Node next;

        Node( int data )
        {
            this.data = data;
        }
    }

    void insert( int data )
    {
        Node newNode = new Node( data );
        newNode.next = null;

        if( head == null )
        {
            head = newNode;
            return;
        }

        Node temp = head;
        while( temp.next != null )
        {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    
    //Time: O(N), Space: O(1)
    void insertNodeInSortedLinkedList(Node head, Node toBeInserted)
    {
        Node current=head;
        Node prev= null;
        while(current!= null && current.data < toBeInserted.data)
        {
                prev=current;
                current=current.next;
        }
        prev.next=toBeInserted;
        toBeInserted.next=current;
    }
    
    void printList( Node head )
    {
        Node temp = head;
        while( temp != null )
        {
            System.out.print( temp.data + " " );
            temp = temp.next;
        }
    }
    
    public static void main( String[] args )
    {
        InsertNodeInSortedLinkedList list = new InsertNodeInSortedLinkedList();
        list.insert( 10 );
        list.insert( 20 );
        list.insert( 30 );
        list.insert( 40 );
        list.insert( 50 );

        System.out.println( "The list is:" );
        list.printList( list.head );
        
        Node newNode=new InsertNodeInSortedLinkedList().new Node(25);
        list.insertNodeInSortedLinkedList( list.head, newNode );
        
        System.out.println( "The list after insertion is:" );
        list.printList( list.head );
    }
}
