package com.sample.datastructure.linkedlist;

public class RecursivelyReverseLinkedList
{
    private Node head;
    class Node
    {
        private int data;
        private Node next;
        
        Node(int data)
        {
            this.data=data;
            this.next=next;
        }
    }
    
    void insert(int data)
    {
        Node newNode = new Node(data);
        newNode.next=null;
        
        if(head == null)
        {
            head=newNode;
            return;
        }
        
        Node temp=head;
        while(temp.next!= null)
        {
            temp=temp.next;
        }
        temp.next=newNode;
        
        return;
    }
    
    
    //O(n) and space O(n due to extra space of recursive stack)
    void reverse(Node head) {
        if (head == null)
            return;

        reverseUtil(null, head);
    }

    void reverseUtil(Node prev, Node node) {
        if (node.next != null)
            reverseUtil(node, node.next); // not at end --> go deeper
        else
            head = node; // at end --> set it as new head

        node.next = prev; // switch references
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
        RecursivelyReverseLinkedList list = new RecursivelyReverseLinkedList();
        list.insert( 10 );
        list.insert( 20 );
        list.insert( 40 );
        list.insert( 60 );
        
        System.out.println( "The List is:" );
        list.printList( list.head );
        
        System.out.println( "\nThe reverse list is:" );
        list.reverse( list.head );
        list.printList( list.head );
    }

}
