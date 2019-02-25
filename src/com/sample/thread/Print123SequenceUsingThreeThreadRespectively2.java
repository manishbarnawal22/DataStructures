package com.sample.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Print123SequenceUsingThreeThreadRespectively2 {

	Object monitor = new Object();
	AtomicInteger number = new AtomicInteger(0);

	public static void main(String[] args) {
		Print123SequenceUsingThreeThreadRespectively2 tnp = new Print123SequenceUsingThreeThreadRespectively2();
		Thread t1 = new Thread(tnp.new Printer(0, 3));
		Thread t2 = new Thread(tnp.new Printer(1, 3));
		Thread t3 = new Thread(tnp.new Printer(2, 3));

		t1.start();
		t2.start();
		t3.start();
	}

	class Printer implements Runnable {

		int threadId;
		int numOfThreads;

		public Printer(int id, int nubOfThreads) {
			threadId = id;
			this.numOfThreads = nubOfThreads;
		}

		public void run() {
			print();
		}

		private void print() {

			int capacity = 20;
			try {
				while (true) {
					synchronized (monitor) {
						
						if (number.get() <= capacity) {
							if (number.get() % numOfThreads != threadId) {
								monitor.wait();
							} else {
								System.out
										.println("ThreadId [" + threadId + "] printing -->" + number.getAndIncrement());
								monitor.notifyAll();
							}
						}
						else
						{
							break;
						}
					}
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
