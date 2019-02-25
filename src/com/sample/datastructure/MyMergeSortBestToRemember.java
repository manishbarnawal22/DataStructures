package com.sample.datastructure;


//https://www.youtube.com/watch?v=TzeBrDU-JaY-
//Incase of merge sort an extra space needs to be added as an array for storing the left and right data.
//So incase of arrays this will be a problem.
//1. Unlike array, in linked list, we can insert items in the middle in O(1) extra space and O(1) time. 
//	 Therefore merge operation of merge sort can be implemented without extra space for linked lists.

//2. Quick Sort requires a lot of this kind of access. In linked list to access i’th index, 
//   we have to travel each and every node from the head to i’th node as we don’t have continuous block of memory. 
//	 Therefore, the overhead increases for quick sort. Merge sort accesses data sequentially 
//	 and the need of random access is low.
public class MyMergeSortBestToRemember {
 
    public static void main(String a[]){
         
        int[] inputArr = {45,23,11,89,77,98,4,28,65,21};
        MyMergeSortBestToRemember mms = new MyMergeSortBestToRemember();
        mms.doMergeSort(inputArr);
        for(int i:inputArr){
            System.out.print(i);
            System.out.print(" ");
        }
    }
 
    private void doMergeSort(int[] inputArr) {
        
    	int n = inputArr.length;
    	//the below condition is for if the array contains only one element or other way after the 
    	//recursive calls at one point of time only one element will be left in the left and right array
    	//at last of the recursive call and we know that one element is sorted by itself hence we return
    	// as a base condition.
    	if(n < 2)
    	{
    		return;
    	}
    	
    	int mid = n/2;
    	int[] left = new int[mid];
    	int[] right = new int[n-mid];
    	
    	for(int i=0; i< mid; i++)
    	{
    		left[i] = inputArr[i];
    	}
    	
    	for(int i=mid; i< n; i++)
    	{
    		right[i-mid] = inputArr[i];
    	}
    	
    	doMergeSort(left);
    	doMergeSort(right);
    	mergeParts(left, right, inputArr);
    }
 
    private void mergeParts(int[] left, int[] right, int[] inputArr) {
 
        int nLeft = left.length;
        int nRight = right.length;
        int i = 0;
        int j = 0;
        int k = 0;
        
        //In this loop one of the subarray either left or right array which has smaller number of elements
        //will be filled faster. So for the remaining element to get filled we write separate 
        //while loops down the line.
        while(i< nLeft && j< nRight)
        {
        	if(left[i] <= right[j])
        	{
        		inputArr[k] = left[i];
        		i++;
        	}
        	else
        	{
        		inputArr[k] = right[j];
        		j++;
        	}
        	k++;
        }
 
        //If the right array is completed fast above then some elements in the left array will remain and hence need
        //to copy those in the inputArray.
        while(i< nLeft)
        {
        	inputArr[k] = left[i];
        	i++;
        	k++;
        }
        
        //If the left array is completed fast above then some elements in the right array will remain and hence need
        //to copy those in the inputArray.
        while(j < nRight)
        {
        	inputArr[k] = right[j];
        	j++;
        	k++;
        }
    }
}

