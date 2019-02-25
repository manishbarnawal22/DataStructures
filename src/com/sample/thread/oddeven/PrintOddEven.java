package com.sample.thread.oddeven;

public class PrintOddEven {

	public static void main(String[] args) {
		OddEvenLogic lObj = new OddEvenLogic();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					lObj.printOddEven();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					lObj.printOddEven();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		
		

		t1.start();
		t2.start();
		//t3.start();
	}
}

class OddEvenLogic {
	int count = 1;
	int MAX = 100;
	Object lock = new Object();

	void printOddEven() throws InterruptedException {
		while (count <= MAX) {
			synchronized (lock) {
				if (count % 2 == 0) {
					System.out.println("Even Thread "+Thread.currentThread().getName()+" : "+count);
					count++;
					lock.notify();
					Thread.sleep(1000);
					lock.wait();
				} else {
					System.out.println("Odd Thread "+Thread.currentThread().getName()+" : "+count);
					count++;
					lock.notify();
					Thread.sleep(1000);
					lock.wait();
				}
				
			}
		}

	}

}
