package com.sample.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Latch
{
    private static CountDownLatch lCountDownLatch = new CountDownLatch( 3 );
    
    public static void main( String[] args ) throws InterruptedException
    {
        

        System.out.println( "Latch Count :"+lCountDownLatch.getCount() );
        //Waiter lWaiter = new Waiter( lCountDownLatch );
        Decrementor1 lDecrementor1 = new Decrementor1( lCountDownLatch );
        Decrementor2 lDecrementor2 = new Decrementor2( lCountDownLatch );
        Decrementor3 lDecrementor3 = new Decrementor3( lCountDownLatch );
        
        /*new Thread( lWaiter ).start();
        Thread.sleep( 1000 );*/
        new Thread( lDecrementor1 ).start();
        new Thread( lDecrementor2 ).start();
        new Thread( lDecrementor3 ).start();
        
        System.out.println( "Main Thread before await latch count:"+lCountDownLatch.getCount() );
        lCountDownLatch.await();
        
        System.out.println( "Main Thread after await latch count:"+lCountDownLatch.getCount() );
        System.out.println( "Main Thread done." );
    }
}

class Waiter implements Runnable
{
    CountDownLatch latch;

    Waiter( CountDownLatch latch )
    {
        this.latch = latch;
    }

    @Override
    public void run()
    {
        try
        {
            System.out.println( "Waiter calling await()" );
            System.out.println( "Latch Count just before Waiter await():"+latch.getCount() );
            latch.await();
            System.out.println( "Waiter after await()" );
            System.out.println( "Latch Count just after Waiter await():"+latch.getCount() );
        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }
        System.out.println( "Waiter Released." );
    }
}

class Decrementor1 implements Runnable
{
    CountDownLatch latch;

    Decrementor1( CountDownLatch latch )
    {
        this.latch = latch;
    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep( 1000 );
            latch.countDown();

            System.out.println( "Decrementor1 countDown:"+latch.getCount() );
        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }
    }
}

class Decrementor2 implements Runnable
{
    CountDownLatch latch;

    Decrementor2( CountDownLatch latch )
    {
        this.latch = latch;
    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep( 2000 );
            latch.countDown();

            System.out.println( "Decrementor2 countDown:"+latch.getCount() );

        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }
    }
}

class Decrementor3 implements Runnable
{
    CountDownLatch latch;

    Decrementor3( CountDownLatch latch )
    {
        this.latch = latch;
    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep( 3000 );
            latch.countDown();

            System.out.println( "Decrementor3 countDown:"+latch.getCount() );

        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }
    }
}
