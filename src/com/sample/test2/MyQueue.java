package com.sample.test2;

public class MyQueue {

	int limit;
	int[] queue;
	int front = 0;
	int rear = -1;
	
	MyQueue(int limit)
	{
		this.limit = limit;
		queue = new int[limit];
	}
	
	void add(Integer element)
	{
		if(isFull())
		{
			System.out.println("Queue is full. Please remove some element.");
		}
		else
		{
			queue[++rear] =  element;			
		}
	}
	
	int remove()
	{
		if(isEmpty())
		{
			System.out.println("The queue is empty.");
			return -1;
		}
		else
		{
			return queue[front++] ;			
		}
	}
	
	boolean isFull()
	{
		return rear==limit;
	}
	
	boolean isEmpty()
	{
		return front==limit;
	}
	
	int[] printArr()
	{
		return queue;
	}
	
	public static void main(String[] args) {

		MyQueue q = new MyQueue(5);
		q.add(10);
		q.add(20);
		q.add(30);
		
		System.out.println("Queue contains:");
		int[] arrayOfElement = q.printArr();
		
		for(int element: arrayOfElement)
		{
			System.out.print(element+" ");
		}
		
		q.remove();
		q.remove();
		
		System.out.println("After removal Queue contains:");
		int[] arrayOfElement1 = q.printArr();
		
		for(int element: arrayOfElement1)
		{
			System.out.println(element);
		}
		
	}

}

