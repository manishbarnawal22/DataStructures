package com.sample.arrays;

import java.util.Stack;

/*
 * In a Stack, keep track of maximum value in it. It might be the top element 
 * in the stack but once it is poped out, the maximum value should 
 * be from the rest of the elements in the stack.
 */
public class TrackCurrentMaximumElementOnAStack {

	static Stack<Integer> trackStk = new Stack<Integer>();
	static Stack<Integer> mainStk = new Stack<Integer>();
	
	public static void main(String[] args) {
		//input elements {4, 2, 14, 1, 18};

		TrackCurrentMaximumElementOnAStack lTrackCurrentMaximumElementOnAStack = new TrackCurrentMaximumElementOnAStack();

		lTrackCurrentMaximumElementOnAStack.push(4);
		lTrackCurrentMaximumElementOnAStack.push(2);
		lTrackCurrentMaximumElementOnAStack.push(14);
		
		lTrackCurrentMaximumElementOnAStack.pop();
		
		lTrackCurrentMaximumElementOnAStack.push(1);
		lTrackCurrentMaximumElementOnAStack.push(18);
		
		System.out.println("Main Stack:"+mainStk);
		System.out.println("Track Stack:"+trackStk);
	}
	
	int pop()
	{
		if(!mainStk.isEmpty())
		{
			trackStk.pop();
			mainStk.pop();
		}
		return 0;
	}
	
	void push(Integer element)
	{
		if(mainStk.isEmpty())
		{
			mainStk.push(element);
			trackStk.push(element);
		}
		else
		{
			if(element!=null)
			{
				mainStk.push(element);
				if(element > trackStk.peek())
				{
					trackStk.push(element);
				}
				else
				{
					trackStk.push(trackStk.peek());
				}
			}
		}
	}

}
