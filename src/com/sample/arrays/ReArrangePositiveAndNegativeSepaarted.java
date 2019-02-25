package com.sample.arrays;

public class ReArrangePositiveAndNegativeSepaarted {
	static Integer[] arr = new Integer[] {1,5,-3, 6,-2, 7};
	public static void main(String[] args) {

		printAllNegativeAndPositiveTogether();
		printArray(arr, arr.length);
		
	}
	
	 static void printArray(Integer arr[], int n) 
	    { 
	        for (int i = 0; i < n; i++) 
	            System.out.print(arr[i] + " "); 
	    } 

	private static void printAllNegativeAndPositiveTogether() {

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
