package com.sample.arrays;

public class FindAllTheLeadersOfAnArray {

	//The leader of an array are the ones which has all elements on 
	//the right side smaller than this element.
	//E.g. {16, 17, 4, 3, 5, 2} in this array the leaders are 17, 5, 2 
	public static void main(String[] args) {

		int[] arr = {16, 17, 4, 3, 5, 2};
		printLeaders(arr);
	}

	private static void printLeaders(int[] arr) {

		int size = arr.length;
		//As this is the rightmost element so is the leader as no other element is there
		//which is greater then this on the right hand side.
		int maxFromRight = arr[size-1];
		System.out.print(maxFromRight+" ");
		for(int i=size-2; i>=0; i--)
		{
			if(arr[i] > maxFromRight)
			{
				maxFromRight = arr[i];
				System.out.print(maxFromRight+" ");
			}
		}
		
		
	}

}
