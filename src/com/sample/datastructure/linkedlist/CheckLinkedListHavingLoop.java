package com.sample.datastructure.linkedlist;

import java.util.HashSet;

public class CheckLinkedListHavingLoop
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

    void printList( Node head )
    {
        Node temp = head;
        while( temp != null )
        {
            System.out.print( temp.data + " " );
            temp = temp.next;
        }
    }

    //Time complexity O(n) and space complexity O(n)
    boolean checkLinkedListHavingLoop( Node head )
    {
        HashSet<Node> hashSet = new HashSet<Node>();
        Node temp = head;
        while( temp != null )
        {
            if( hashSet.contains( temp ) )
            {
                System.out.println( "Loop found" );
                return true;
            }
            hashSet.add( temp );
            temp = temp.next;
        }
        return false;
    }

    //Floyd’s Cycle-Finding Algorithm
    //Move one slow pointer one hop and other fast pointer two hops , if they coincide then there is a loop.
    //Memoryless approach
    boolean detectLoopFloydAlgorithm( Node head )
    {
        Node slow_p = head;
        Node fast_p = head;
        while( slow_p != null && fast_p != null && fast_p.next != null )
        {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;

            if( slow_p == fast_p )
            {
                System.out.println( "Loop found." );
                return true;
            }
        }
        return false;
    }

    //Time: O(N) Space: O(1)
    Node findStartNodeWhenLoopStarts( Node head )
    {
        Node slow_p = head;
        Node fast_p = head;
        boolean loopExists = false;
        while( slow_p != null && fast_p != null && fast_p.next != null )
        {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;

            if( slow_p == fast_p )
            {
                System.out.println( "Loop found." );
                loopExists = true;
                break;
            }
        }

        if( loopExists )
        {
            slow_p = head;
            while( slow_p != fast_p )
            {
                slow_p = slow_p.next;
                fast_p = fast_p.next;
            }
            return fast_p;
        }
        else
            return null;
    }

    //Time O(N), Space O(1)
    int findLengthOfLoop( Node head )
    {
        Node slow_p = head;
        Node fast_p = head;
        boolean loopExists = false;
        while( slow_p != null && fast_p != null && fast_p.next != null )
        {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;

            if( slow_p == fast_p )
            {
                loopExists = true;
                break;
            }
        }

        int loopLength = 0;
        if( loopExists )
        {
            do
            {
                fast_p = fast_p.next;
                loopLength++;
            }
            while( slow_p != fast_p );
        }
        return loopLength;
    }

    public static void main( String[] args )
    {
        CheckLinkedListHavingLoop list = new CheckLinkedListHavingLoop();
        list.insert( 10 );
        list.insert( 20 );
        list.insert( 30 );
        list.insert( 40 );
        list.insert( 50 );

        System.out.println( "The list is:" );
        list.printList( list.head );

        list.head.next.next.next.next = list.head.next;

        //list.checkLinkedListHavingLoop( list.head );
        //OR
        //the below Floyd Algo to fast traverse.
        list.detectLoopFloydAlgorithm( list.head );

        Node loopHead = list.findStartNodeWhenLoopStarts( list.head );
        System.out.println( "Loop head:" + loopHead.data );

        int lengthOfLoop = list.findLengthOfLoop( list.head );
        System.out.println( "Length of loop:" + lengthOfLoop );

    }
}
