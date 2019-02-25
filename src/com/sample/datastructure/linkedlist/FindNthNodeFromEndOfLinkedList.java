package com.sample.datastructure.linkedlist;

import java.util.Hashtable;

public class FindNthNodeFromEndOfLinkedList
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

        Node tail = head;
        while( tail.next != null )
        {
            tail = tail.next;

        }
        tail.next = newNode;
    }
    
    void printList(Node head)
    {
        Node temp = head;
        while(temp!=null)
        {
            System.out.print( temp.data + " " );
            temp=temp.next;
        }
    }
    
    int getSize(Node head)
    {
        int size=0;
        Node temp = head;
        while(temp!=null)
        {
            temp=temp.next;
            size++;
        }
        
        return size;
    }
    
    //Time = O(n), Space = O(m)
    Node findNthNodeFromLastOrderNTime(Node head, int n)
    {
        int count=0;
        Hashtable<Integer,Node> table = new Hashtable<>();
        Node temp=head;
        while(temp!= null)
        {
            count++;
            table.put(count , temp );
            temp = temp.next;
        }
        
        Node resultNode = table.get( table.size()-n+1);
        
        
        return resultNode;
    }
    
    //Time = O(n), Space = O(1) here we don;t need to craete the HashTable and the space complexity also decreases.
    /*So, we can find the length of the list without creating the hash table. After finding the length, compute M –
    n + 1 and with one more scan we can get the M – n + 1th node from the beginning. This solution
    needs two scans: one for finding the length of the list and the other for finding M – n + 1th node
    from the beginning.*/
    Node findNthNodeFromLastOrderNTimeAndSpaceOrder1(Node head, int n)
    {
        int listSize=getSize( head );
        Node temp=head;
        int count =1;
        while(temp!= null && count<listSize-n+1 )
        {
            count++;
            temp=temp.next;
        }
        
        Node resultNode = temp;
        
        return resultNode;
    }
    
    //O(n) time and O(1) space complexity in one scan, best and efficient way.
    Node findNthNodeFromLastInOneScan(Node head, int n)
    {
        Node mainPtr=head;
        Node refPointer = head;
        int count = 0;
        while(count< n)
        {
            refPointer = refPointer.next;
            count++;
        }
        while(refPointer!=null)
        {
            refPointer=refPointer.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }
    
    //O(n) and O(n)
    //Need to check this. This giving wrong result.
    Node findNthNodeFromLastUsingRecursion(Node head, int n)
    {
        int count =0;
        if(head == null)
        {
            return head;
        }
        
        Node temp = head;
        if(temp != null)
        {
            count++;
            temp=temp.next;
            findNthNodeFromLastUsingRecursion(temp, n);
        }
        
        if(count==n)
        {
            System.out.println( temp.data );
            return temp;
        }
        
        return temp;
    }
    
    public static void main( String[] args )
    {
        FindNthNodeFromEndOfLinkedList list=new FindNthNodeFromEndOfLinkedList();
        list.insert( 10 );
        list.insert( 20 );
        list.insert( 30 );
        list.insert( 40 );
        list.insert( 50 );
        list.insert( 60 );
        
        System.out.println( "The list is:" );
        list.printList(list.head);
        
        /*System.out.println( "\nFind the 3rd Node from end of List using O(n) time complexity and O(m) space." );
        Node nodeFromLastImproved = list.findNthNodeFromLastOrderNTime( list.head, 3 );
        System.out.println( "The 3rd node from last of list is:"+nodeFromLastImproved.data );
        
        System.out.println( "\nFind the 3rd Node from end of List using O(n) time complexity and O(1) space." );
        Node nodeFromLastImproved1 = list.findNthNodeFromLastOrderNTimeAndSpaceOrder1( list.head, 3 );
        System.out.println( "The 3rd node from last of list is:"+nodeFromLastImproved1.data );*/
        
        System.out.println( "\nFind the 2nd Node from end of List." );
        Node nodeFromLast = list.findNthNodeFromLastInOneScan( list.head, 2 );
        System.out.println( "The 3rd node from last of list is:"+nodeFromLast.data );
        
       /* System.out.println( "\nFind the 3rd Node from end of List using recursion." );
        Node findNthNodeFromLastUsingRecursion = list.findNthNodeFromLastUsingRecursion( list.head, 3 );
        System.out.println( "The 3rd node from last of list is:"+findNthNodeFromLastUsingRecursion.data );*/
        
    }
}
