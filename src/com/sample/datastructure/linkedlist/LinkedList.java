package com.sample.datastructure.linkedlist;

public class LinkedList
{
    Node head;

    class Node
    {
        int data;
        Node next;

        Node( int data )
        {
            this.data = data;
            this.next = null;
        }
    }

    public void addNodeInFront( int newData )
    {
        Node newNode = new Node( newData );
        newNode.next = head;

        head = newNode;
    }

    public void insertAfter( Node prevNode,
                             int newData )
    {
        if( prevNode == null )
        {
            System.out.println( "The given previous node cannot be null." );
            return;
        }

        Node newNode = new Node( newData );
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    public void append( int newData )
    {
        //always create one node
        Node newNode = new Node( newData );
        newNode.next = null;

        if( head == null )
        {
            //this is the first node and no other node is available
            head = newNode;
            return;
        }

        //traverse till the last node. create a last reference variable and start moving that from head to tail.
        Node temp = head;
        while( temp.next != null )
        {
            temp = temp.next;
        }
        temp.next = newNode;

        return;
    }
    
    //Given the data delete the first occurrence of the data
    public void deleteNode(int data)
    {
        Node tNode = head;
        Node prevNode = null;
        
            //If there is only one node and the data is matched then nullify
            if(tNode!= null && data==(tNode.data))
            {
                head = head.next;
                return;
            }
            //search for the data to be deleted
            while(tNode != null && tNode.data != data)
            {
                prevNode = tNode;
                tNode = tNode.next;
            }
            
            //means it reached the last node and doesnot found the matching data
            if(tNode == null)
            {
                return;
            }
            prevNode.next = tNode.next;
            tNode.next= null;
    }

    public void printList()
    {
        Node tNode = head;
        while( tNode != null )
        {
            System.out.print( tNode.data + " " );
            tNode = tNode.next;
        }
    }
    
    public static void main( String[] args )
    {
        LinkedList list = new LinkedList();
        list.append( 6 );
        list.addNodeInFront( 7 );
        list.addNodeInFront( 1 );
        list.append( 4 );
        //insert after 7
        list.insertAfter( list.head.next, 8 );
        System.out.println( "Created Linked List:" );
        list.printList();
        // o/p: 1 7 8 6 4 
        //delete 8
        list.deleteNode( 8 );
        System.out.println( "\n" );
        list.printList();
        //o/p: 1 7 6 4
        
        //delete 6
        list.deleteNode( 6 );
        System.out.println( "\n" );
        list.printList();
    }
}