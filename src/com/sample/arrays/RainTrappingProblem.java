package com.sample.arrays;

public class RainTrappingProblem {

	//https://www.geeksforgeeks.org/trapping-rain-water/
	
	public static void main(String[] args) {

		//int[] arr = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int[] arr = new int[] { 3, 0, 0, 2, 0, 4, 0, 2 };
		
		System.out.println("Maximum water that can be accumulated is " + findWaterCapacity(arr, arr.length));
		System.out.println("Maximum water that can be accumulated is " + findWater(arr, arr.length));

	}
	
	//The below solution has timeComplexity of O(n) and space complexity of O(1)
	static int findWaterCapacity(int A[], int n)
	{
		int left =0;
		int right=n-1;
		int maxLeft=0;
		int maxRight=0;
		int sum = 0;
		
		while(left <= right)
		{
			if(A[left] <= A[right])
			{
				if(A[left] >= maxLeft)
				{
					maxLeft = A[left];
				}
				else
				{
					sum+= maxLeft - A[left];
				}
				left++;
			}
			else
			{
				if(A[right] >= maxRight)
				{
					maxRight = A[right];
				}
				else
				{
					sum+= maxRight - A[right];
				}
				right--;
			}
		}
		
		return sum;
	}
	
	
	//This has time complexity O(n) and Space complexity of O(n)
	// Method for maximum amount of water 
    static int findWater(int arr[], int n) 
    { 
        // left[i] contains height of tallest bar to the 
        // left of i'th bar including itself 
        int left[] = new int[n]; 
       
        // Right [i] contains height of tallest bar to 
        // the right of ith bar including itself 
        int right[] = new int[n]; 
       
        // Initialize result 
        int water = 0; 
       
        // Fill left array 
        left[0] = arr[0]; 
        for (int i = 1; i < n; i++) 
           left[i] = Math.max(left[i-1], arr[i]); 
       
        // Fill right array 
        right[n-1] = arr[n-1]; 
        for (int i = n-2; i >= 0; i--) 
           right[i] = Math.max(right[i+1], arr[i]); 
       
        // Calculate the accumulated water element by element 
        // consider the amount of water on i'th bar, the 
        // amount of water accumulated on this particular 
        // bar will be equal to min(left[i], right[i]) - arr[i] . 
        for (int i = 0; i < n; i++) 
           water += Math.min(left[i],right[i]) - arr[i]; 
       
        return water; 
    }
}
