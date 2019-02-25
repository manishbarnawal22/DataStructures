package com.sample.datastructure.linkedlist;

public class DoublyLinkedList
{

    private Node head;

    class Node
    {
        private int data;
        private Node prev;
        private Node next;

        Node( int data )
        {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    //insert at the front of list
    void insert( int newValue )
    {
        Node newNode = new Node( newValue );
        newNode.next = head;
        newNode.prev = null;

        //change from linked list. Here we update the prev. Just one more step below.
        if( head != null )
        {
            head.prev = newNode;
        }

        head = newNode;
    }

    //insert a new node after the given node
    void insertAfter( Node prevNode,
                      int newData )
    {
        if( prevNode == null )
        {
            System.out.println( "The previous node cannot be null." );
            return;
        }

        Node newNode = new Node( newData );
        
        //Change from linked list two more steps below.
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        
        newNode.prev = prevNode;
        
        if( newNode.next != null )
        {
            newNode.next.prev = newNode;
        }
    }

    //Add a new node at the end of the list.
    void append( int newData )
    {
        Node newNode = new Node( newData );
        newNode.next = null;

        if( head == null )
        {
            newNode.prev = null;
            head = newNode;
            return;
        }

        Node last = head;
        while( last.next != null )
        {
            last = last.next;
        }
        last.next = newNode;

        //change from linkedList just the below step.
        newNode.prev = last;
    }
    
    void deleteNode(Node head, Node nodeToBeDeleted)
    {
        if(head == nodeToBeDeleted)
        {
            head = nodeToBeDeleted.next;
        }
        //if node to be deleted is not the last node
        if(nodeToBeDeleted.next!=null)
        {
            nodeToBeDeleted.next.prev=nodeToBeDeleted.prev;
        }
        
        if(nodeToBeDeleted.prev != null)
        {
            nodeToBeDeleted.prev.next=nodeToBeDeleted.next;
        }
        
        return;
    }

    void printList( Node node )
    {
        Node last = null;

        System.out.println( "Print in forward direction:" );
        while( node != null )
        {
            System.out.print( node.data + " " );
            last = node;
            node = node.next;
        }

        System.out.println(  );
        System.out.println( "Print in backward direction:" );
        while( last != null )
        {
            System.out.print( last.data + " " );
            last = last.prev;
        }
        
        System.out.println(  );
        System.out.println(  );
    }
    
    //Given a node as next_node, insert a new node before the given node *
    void insertBefore(Node nextNode, int newData)
    {
        if(nextNode == null)
        {
            System.out.println( "The given next node cannot be null." );
            return;
        }
        Node newNode = new Node(newData);
        newNode.prev=nextNode.prev;
        nextNode.prev=newNode;
        newNode.next=nextNode;
                
        if(newNode.prev != null)
        {
            newNode.prev.next=newNode;
        }
    }
    
    public static void main( String[] args )
    {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.append( 20 );
        dll.append( 49 );
        dll.append( 51 );
        
        dll.printList( dll.head );
        
        System.out.println( "Insert 18 in front." );
        dll.insert( 18 );
        dll.printList( dll.head );
        
        System.out.println( "Insert 23 after node 20." );
        dll.insertAfter( dll.head.next, 23 );
        dll.printList( dll.head );
        
        System.out.println( "Insert 35 before node 23." );
        dll.insertBefore( dll.head.next, 35 );
        dll.printList( dll.head );
        
        System.out.println( "Delete Node 20." );
        dll.deleteNode( dll.head, dll.head.next.next );
        dll.printList( dll.head );
    }

}
