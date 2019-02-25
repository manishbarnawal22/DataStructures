package com.sample.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicateNumberOnIntegerArray {

	public static void main(String[] args) {
		Integer arr[] = {1,3,5,3,6,45,7,9,45,8,9,5};
		FindDuplicateNumberOnIntegerArray obj=new FindDuplicateNumberOnIntegerArray();
		obj.findDuplicateNumberInArray(arr);
		
		Integer arr1[] = {10,3,5,8,67,6,9};
		obj.largestAndSmallest(arr1);
		
		Integer[] arr2={4,9,3,5,1,8};
		Integer number=9;
		obj.findAllPairsOfIntegerArrayWhoseSumIsEqualToGivenNumber(arr2, number);
	}
	
	void findDuplicateNumberInArray(Integer[] arr)
	{
		Arrays.sort(arr);
		System.out.println("The sorted array is:");
		for (Integer integer : arr) {
			System.out.print(integer + " ");	
		}
		
		int previous=arr[0];
		
		for(int i=0; i<arr.length-1;i++)
		{
			if(previous==arr[i+1])
			{
				System.out.println("\nThe duplicate element is:"+previous);
			}
			
			previous=arr[i+1];
		}
	}
	
	public void largestAndSmallest(Integer[] numbers) {
		
		Integer largest=numbers[0];
		Integer smallest=numbers[0];
		
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i]>smallest)
			{
				largest=numbers[i];
			}
			else if(numbers[i]<largest)
			{
				smallest=numbers[i];
			}
		}
		
		System.out.println("Given integer array : " + Arrays.toString(numbers));
		System.out.println("Largest number in array is : " + largest);
		System.out.println("Smallest number in array is : " + smallest);
	}
	
	public void findAllPairsOfIntegerArrayWhoseSumIsEqualToGivenNumber(Integer[] arr2, Integer number)
	{
		printPairsUsingSet(arr2,number);

	}
	
	public void printPairsUsingSet(Integer[] numbers, int n)
	{
		
		if(numbers.length < 2)
		{
			return; 
		} 
		
		Set<Integer> set = new HashSet<>(numbers.length); 
		for(int value : numbers)
		{
			int target = n - value; 
			if(!set.contains(target))
			{ 
				set.add(value); 
			}
			else 
			{ 
				System.out.printf("(%d, %d) %n", value, target); 
			}
		}
	}
	
}
