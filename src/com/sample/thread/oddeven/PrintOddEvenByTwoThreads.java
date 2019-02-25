package com.sample.thread.oddeven;

public class PrintOddEvenByTwoThreads {

	public static void main(String[] args) {

		int MAX = 20;
		OddEvenPrinter lObj = new OddEvenPrinter();
		Thread odd = new Thread(new Runnable() {
			@Override
			public void run() {
				int num = 0;
				while (true) {
					if (num > MAX) {
						break;
					}
					try {
						
						num = lObj.printOdd();
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}

		});

		Thread even = new Thread(new Runnable() {
			@Override
			public void run() {
				int num=0;
				while (true) {
					if (num > MAX) {
						break;
					}
					try {
						num = lObj.printEven();
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		odd.start();
		even.start();
	}
}

class OddEvenPrinter
{
	int count =0;
	boolean isEven=true;
	Object lock = new Object();
	
	int printEven() throws InterruptedException
	{
		 synchronized(lock)
		 {
			 if(isEven == true)
				{
					lock.wait();
				}
				count++;
				isEven=true;
				System.out.println("Even: "+Thread.currentThread().getName()+": "+count);
				lock.notify();	 
		 }
		
		return count;
	}
	
	int printOdd() throws InterruptedException
	{
		synchronized(lock)
		 {
			if(isEven==false)
			{
				lock.wait();
			}
			count++;
			isEven=false;
			System.out.println("Odd: "+Thread.currentThread().getName()+": "+count);
			lock.notify();
		 }
				
		return count;
	}
	
	
}
