package com.sample.arrays;

public class FindMaximumSumInAGivenArray {

	Integer[] arr1 = new Integer[] {-2, -3, 4, -1, -2, 1, 5, -3};
	
	//Brute force method
	Integer findMaximumSum()
	{
		int maxSumNow = arr1[0];
		for(int i=0; i< arr1.length; i++)
		{
			int sum = 0;
			for(int j=i; j< arr1.length; j++)
			{
				sum = sum+arr1[j];
				if(sum > maxSumNow)
				{
					maxSumNow = sum;
				}
			}
		}
		
		return maxSumNow;	
	}
	
	//Kadanes algo
	Integer findMaximumSumKandanesAlgo()
	{
		int maxSoFar = 0;
		int maxEndingHere = 0;
		
		for(int i=0; i< arr1.length; i++)
		{
			maxEndingHere = maxEndingHere + arr1[i];
			if(maxEndingHere < 0)
			{
				maxEndingHere = 0;
			}
			else if(maxSoFar < maxEndingHere)
			{
				maxSoFar = maxEndingHere;
			}
		}
		return maxSoFar;
	}
	
	//Kadanes algo to find the max sum and its sub array
	void findMaximumSumSubArrayKandanesAlgo()
	{
		int maxSoFar = 0;
		int maxEndingHere = 0;
		int start = 0; int end = 0; int s = 0; 
		
		for(int i=0; i< arr1.length; i++)
		{
			maxEndingHere = maxEndingHere + arr1[i];
			if(maxEndingHere < 0)
			{
				maxEndingHere = 0;
				s = i+1;
			}
			else if(maxSoFar < maxEndingHere)
			{
				maxSoFar = maxEndingHere;
				start = s;
				end = i;
			}
		}
		System.out.println("The maximum sum using kadanes algo is:"+maxSoFar);
		System.out.println("Starting Index:"+start);
		System.out.println("Ending index:"+end);
	}
	
	public static void main(String[] args) {
		
		FindMaximumSumInAGivenArray findMaxSum = new FindMaximumSumInAGivenArray();
		System.out.println("The max sum using brute borce method is:"+findMaxSum.findMaximumSum());
		
		System.out.println("The max sum using Kandanes algo is:"+findMaxSum.findMaximumSumKandanesAlgo());
		
		findMaxSum.findMaximumSumSubArrayKandanesAlgo();
	}
}
