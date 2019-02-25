package com.sample.thread;

public class Print12345SequenceUsingFiveThreadRespectively {

	private volatile Integer count = 1;
	private volatile Integer threadIdToRun = 1;
	private Object object = new Object();

	public static void main(String[] args) {

		Print12345SequenceUsingFiveThreadRespectively testClass = new Print12345SequenceUsingFiveThreadRespectively();
		Thread t1 = new Thread(testClass.new Printer(1));
		Thread t2 = new Thread(testClass.new Printer(2));
		Thread t3 = new Thread(testClass.new Printer(3));
		Thread t4 = new Thread(testClass.new Printer(4));
		Thread t5 = new Thread(testClass.new Printer(5));

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

	class Printer implements Runnable {

		private int threadId;

		public Printer(int threadId) {
			super();
			this.threadId = threadId;
		}

		@Override
		public void run() {
			try {
				while (count <= 22) {
					synchronized (object) {
						if (threadId != threadIdToRun) {
							object.wait();
						} else {
							System.out.println("Thread " + threadId + " printed " + count);
							count += 1;

							if (threadId == 1)
								threadIdToRun = 2;
							else if (threadId == 2)
								threadIdToRun = 3;
							else if (threadId == 3)
								threadIdToRun = 4;
							else if (threadId == 4)
								threadIdToRun = 5;
							else if (threadId == 5)
								threadIdToRun = 1;

							object.notifyAll();
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
