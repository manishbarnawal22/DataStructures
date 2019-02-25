package com.sample.arrays;

public class FindMissingNumberInAnArray {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,7,8,9,10};
		
		findMissingNumberUsingXor(arr);
	}

	private static void findMissingNumberUsingXor(int[] arr) {
		int xor1 = 1;
		for(int i=1; i<11; i++)
		{
			xor1 ^= i;
		}	
		
		int xor2=arr[0];
		for(int j=0; j< arr.length; j++)
		{
			xor2 ^= arr[j];
		}
		System.out.println(xor1^xor2);
	}
	
}
