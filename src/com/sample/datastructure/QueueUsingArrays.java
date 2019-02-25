package com.sample.datastructure;

import java.util.Scanner;

public class QueueUsingArrays
{
    Integer top;
    int[] arr;
    int size;
    int start = 0;;

    public QueueUsingArrays( int size )
    {
        this.size = size;
        arr = new int[this.size];
        top = -1;
    }

    public void push( Integer element )
    {
        if( !isFull() )
        {
            arr[++top] = element;
        }
        else
        {
            System.out.println( "Queue overflow." );
        }
    }

    public Integer pop()
    {
        if( !isEmpty() )
        {
            return arr[start++];
        }
        else
        {
            System.out.println( "Queue underflow." );
            return -1;
        }
    }

    public int[] getArrayOfElements()
    {
        return arr;
    }

    public boolean isEmpty()
    {
        return ( start == size );
    }

    public boolean isFull()
    {
        return ( top == size - 1 );
    }

    public void printQueueElements()
    {
        System.out.println( "The elements in the queue are: " );
        for( int i : arr )
        {
            System.out.print( i + " " );
        }
        System.out.println();
    }

    public static void main( String[] args )
    {
        Scanner scanner = new Scanner( System.in );
        System.out.println( "Enter the size of the queue:" );
        int size = scanner.nextInt();

        QueueUsingArrays queue = new QueueUsingArrays( size );

        System.out.println( "Enter the elements to be pushed." );
        int start = 0;
        while( start != size )
        {
            start++;
            int element = scanner.nextInt();
            System.out.println( "Element: " + element );
            queue.push( element );

            System.out.println( "Would you like to add more element?" );
            Boolean addMoreElement = scanner.nextBoolean();
            if( addMoreElement )
            {
                continue;
            }
            else
            {
                break;
            }
        }

        queue.printQueueElements();

        System.out.println( "The elements popped are: " );
        while( !queue.isEmpty() )
        {
            System.out.print( queue.pop() + " " );
        }
    }
}
