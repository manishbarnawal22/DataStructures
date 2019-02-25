package com.sample.thread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 
 * This call is synchronous and the thread calling this method suspends execution till a specified number of 
 * threads have called the same method on the barrier. 
 * This situation where the required number of threads have called await(), is called tripping the barrier.
 * Optionally, we can pass the second argument to the constructor, which is a Runnable instance. 
 * This has logic that would be run by the last thread that trips the barrier:
 * 
 * public CyclicBarrier(int parties, Runnable barrierAction)
 * 
 * @author Manish.Barnawal
 *
 */
public class CyclicBarrierTwoArgument
{
    public static void main( String[] args )
    {
        CyclicBarrier lCyclicBarrier1 = new CyclicBarrier( 2, new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println( "Cyclic Barrier1 Business Logic." );
            }
        } );
        
        CyclicBarrier lCyclicBarrier2 = new CyclicBarrier( 2, new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println( "Cyclic Barrier2 Business Logic" );
            }
        } );
        
       (new Thread( new CyclicBarrierRunnable( lCyclicBarrier1, lCyclicBarrier2 ) )).start();
       (new Thread( new CyclicBarrierRunnable( lCyclicBarrier1, lCyclicBarrier2 ) )).start();
    }
    
}

class CyclicBarrierRunnable implements Runnable
{
    CyclicBarrier lCyclicBarrier1;
    CyclicBarrier  lCyclicBarrier2;
    
    public CyclicBarrierRunnable(CyclicBarrier cyclicBarrier1,  CyclicBarrier cyclicBarrier2)
    {
        lCyclicBarrier1=cyclicBarrier1;
        lCyclicBarrier2=cyclicBarrier2;
    }
    
    @Override
    public void run()
    {
        try
        {
            System.out.println( Thread.currentThread().getName() +  " waits at cyclic barrier1." );
            lCyclicBarrier1.await();
            
            System.out.println( Thread.currentThread().getName() + " waits at cyclic barrier2.");
            lCyclicBarrier2.await();
            
        }
        catch( InterruptedException | BrokenBarrierException e )
        {
            e.printStackTrace();
        }
    }
    
}