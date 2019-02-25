package com.sample.thread.oddeven;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenCorrected
{

    public static final int limit = 20;

    public static void main( String... args )
    {
        final Counter counterObj = new Counter( 20 );
        Runnable evenNoPrinter = new Runnable()
        {

            public void run()
            {
                int num = 0;
                while( true )
                {
                    if( num >= limit )
                    {
                        break;
                    }
                    num = counterObj.printOdd();
                }
            }
        };

        Runnable oddNoPrinter = new Runnable()
        {

            public void run()
            {
                int num = 0;
                while( true )
                {
                    if( num >= limit )
                    {
                        break;
                    }
                    num = counterObj.printEven();
                }
            }
        };

        new Thread( oddNoPrinter ).start();
        new Thread( evenNoPrinter ).start();

    }
}

class Counter
{

    private int count = 0;
    private boolean isEven = true;
    private int upperLimit;

    Counter( int limit )
    {
        upperLimit = limit;
    }

    public synchronized int printEven()
    {
        //Wait until odd is available.
        while( isEven == true )
        {
            try
            {
                wait();
            }
            catch( InterruptedException e )
            {
            }
        }
        count++;
        if( count <= upperLimit )
        {
            printEven( count );
        }
        //Toggle status.
        isEven = true;
        //Notify even printer that status has changed.        
        notifyAll();
        return count;

    }

    public synchronized int printOdd()
    {
        //Wait until even is available.
        while( isEven == false )
        {
            try
            {
                wait();
            }
            catch( InterruptedException e )
            {
            }
        }
        count++;
        if( count <= upperLimit )
        {
            printOdd( count );
        }
        //Toggle status.
        isEven = false;
        //Notify odd printer that status has changed.        
        notifyAll();
        return count;
    }

    public void printOdd( int num )
    {
        System.out.println( "ODD # " +Thread.currentThread().getName() +": "+ num );
    }

    public void printEven( int num )
    {
        System.out.println( "EVEN # "+Thread.currentThread().getName() +": " + num );
    }
}
