package com.sample.datastructure.linkedlist;

public class SwapNodeLinkedListWithoutDataSwap
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

    /* Function to swap Nodes x and y in linked list by
       changing links */
    public void swapNodes( int x,
                           int y )
    {
        // Nothing to do if x and y are same
        if( x == y )
            return;

        // Search for x (keep track of prevX and CurrX)
        Node prevX = null, currX = head;
        while( currX != null && currX.data != x )
        {
            prevX = currX;
            currX = currX.next;
        }

        // Search for y (keep track of prevY and currY)
        Node prevY = null, currY = head;
        while( currY != null && currY.data != y )
        {
            prevY = currY;
            currY = currY.next;
        }

        // If either x or y is not present, nothing to do
        if( currX == null || currY == null )
            return;

        // If x is not head of linked list
        if( prevX != null )
            prevX.next = currY;
        else //make y the new head
            head = currY;

        // If y is not head of linked list
        if( prevY != null )
            prevY.next = currX;
        else // make x the new head
            head = currX;

        // Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    void insert( int newData )
    {
        Node newNode = new Node( newData );
        newNode.next = head;
        head = newNode;
    }

    void printList()
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
        SwapNodeLinkedListWithoutDataSwap lListSwap = new SwapNodeLinkedListWithoutDataSwap();
        lListSwap.insert( 1 );
        lListSwap.insert( 2 );
        lListSwap.insert( 3 );
        lListSwap.insert( 4 );
        lListSwap.insert( 5 );
        lListSwap.insert( 6 );
        lListSwap.insert( 7 );

        System.out.println( "The List before Swap is:" );
        lListSwap.printList();
        System.out.println( "" );
        lListSwap.swapNodes( 4, 3 );
        System.out.println( "The List after Swap is:" );
        lListSwap.printList();
    }
}
