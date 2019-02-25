package com.sample.arrays;

import java.util.Arrays;

//Input : A[] = {1, 3, 5, 2}
//Output :  1 5 2 3
//Java program to rearrange the elements
//in array such that even positioned are
//greater than odd positioned elements
public class ReArrangeToEvenPositionNumberGreaterThanOddPositionNumber {

	public static void main(String[] args) {
		
		int[] arr = {1,3,5,2};
		Arrays.sort(arr);

		int arr1[] = new int[4];
		int start=0;
		int end = arr.length-1;
		
		// After sorting all last elements are greater than the previous elements starting from index 1.
		// So at even place if we place all the numbers from last it will always be greater than the 
		//elements in the odd positions which we will put from the start index.
		
		for(int i=0; i< arr.length; i++)
		{
			if((i+1) %2 == 0)
			{
				arr1[i] = arr[end--];
			}
			else
			{
				arr1[i] = arr[start++];
			}
		}
		
		for(int i=0; i<arr1.length; i++)
		{
			System.out.println(arr1[i]+ " ");
		}
		
	}
	
}
