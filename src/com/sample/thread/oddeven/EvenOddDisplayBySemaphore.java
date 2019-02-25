package com.sample.thread.oddeven;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * This demo class is used about inter process of thread communication demo. e.g
 * one thread print Odd number and another thread print even no by using
 * Semaphore
 * 
 */
public class EvenOddDisplayBySemaphore {

	public static void main(String[] args) {
		SharedPrinter printer = new SharedPrinter();

		System.out.println("two different threads to print odd and even number upto max provided, starting from  1 : ");
		// Starting two threads
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new EvenNumberThread(printer, 10));
		executor.execute(new OddNumberThread(printer, 10));
		executor.shutdown();
	}

}

class OddNumberThread implements Runnable {
	SharedPrinter printer;
	int maxNumberTobePrint;

	OddNumberThread(SharedPrinter sp, int index) {
		this.printer = sp;
		this.maxNumberTobePrint = index;
	}

	@Override
	public void run() {
		for (int i = 1; i <= maxNumberTobePrint; i = i + 2) {
			printer.printOddNum(i);
		}
	}
}

/**
 * This class is responsible to generate Even number
 * 
 */
class EvenNumberThread implements Runnable {
	SharedPrinter sp;
	int maxNumberTobePrint;

	EvenNumberThread(SharedPrinter sp, int index) {
		this.sp = sp;
		this.maxNumberTobePrint = index;
	}

	@Override
	public void run() {
		for (int i = 2; i <= maxNumberTobePrint; i = i + 2) {
			sp.printEvenNumber(i);
		}

	}
}

class SharedPrinter {

	// creating instance of 2 semaphores , one is for even and another for odd
	Semaphore evenSemaphore = new Semaphore(0);
	Semaphore oddSemaphore = new Semaphore(1);

	/**
	 * Method for printing even numbers
	 * 
	 * @param num
	 */
	public void printEvenNumber(int num) {
		try {
			evenSemaphore.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(num);
		oddSemaphore.release();
		System.out.println("oddSemaphore after release >>>>>"+oddSemaphore.availablePermits());
	}

	// Method for printing odd numbers
	public void printOddNum(int num) {
		try {
			oddSemaphore.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(num);
		evenSemaphore.release();
		System.out.println("evenSemaphore after release >>>>>"+evenSemaphore.availablePermits());

	}
}
