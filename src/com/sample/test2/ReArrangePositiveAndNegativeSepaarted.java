package com.sample.test2;

public class ReArrangePositiveAndNegativeSepaarted {
	static Integer[] arr = new Integer[] { 12,11,-13,-5,6,-7,5,-3,-6};
	public static void main(String[] args) {

		// this is without maintaining the order
		reArrangePositiveAndNegativeSepaarted();
		printArray(arr, arr.length);
		
	}
	
	 static void printArray(Integer arr[], int n) 
	    { 
	        for (int i = 0; i < n; i++) 
	            System.out.print(arr[i] + " "); 
	    } 

	 //O(n) and space O(1)
	private static void reArrangePositiveAndNegativeSepaarted() {

		 int j = 0, temp; 
	        for (int i = 0; i < arr.length; i++) { 
	            if (arr[i] < 0) { 
	                if (i != j) { 
	                    temp = arr[i]; 
	                    arr[i] = arr[j]; 
	                    arr[j] = temp; 
	                } 
	                j++; 
	            } 
	        }
	}
}
