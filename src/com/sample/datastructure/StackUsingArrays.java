package com.sample.datastructure;

class StackUsingArrays
{
    Integer top;
    int[] arr;
    int size;

    public StackUsingArrays( int size )
    {
        this.size=size;
        arr = new int[this.size];
        top = -1;
    }

    public void push( Integer element )
    {
        if( element != null )
        {
            arr[++top] = element;
        }
    }

    public Integer pop()
    {
        return arr[top--];
    }

    public boolean isEmpty()
    {
        return ( top == -1 );
    }
    
    public boolean isFull()
    {
        return (top == size-1);
    }

    public void printStackElements()
    {
        System.out.println( "The elements in the stack are: " );
        for( int i : arr )
        {
            System.out.print( i + " " );
        }
        System.out.println(  );
    }

    public static void main( String[] args )
    {
        StackUsingArrays stack = new StackUsingArrays( 4 );
        stack.push( 25 );
        stack.push( 35 );
        stack.push( 45 );
        stack.push( 55 );

        System.out.println( "Is Full:" +stack.isFull() );
        
        stack.printStackElements();

        System.out.println( "The elements popped are: " );
        while( !stack.isEmpty() )
        {
            System.out.print( stack.pop() +" " );
        }
    }
}
