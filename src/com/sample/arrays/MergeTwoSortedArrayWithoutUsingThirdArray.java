package com.sample.arrays;


/**
 * Given two sorted arrays, merge with O(1) space complexity i.e. without using third array.
 * 
 * @author Manish.Barnawal
 *
 */
public class MergeTwoSortedArrayWithoutUsingThirdArray {

	public static void main(String[] args) {

		int a[] = {  5, 10, 15, 45, 0, 0, 0, 0, 0 };
		int b[] = { 3, 14, 16, 20, 33 };
		int m = a.length-b.length;
		int n = b.length;

		sortedMerge(a, b, m, n);
		
		System.out.print("Sorted merged list :");
		for (int i = 0; i < a.length; i++)
			System.out.print(" " + a[i]);
	}

	private static void sortedMerge(int[] a, int[] b, int sizeOfA, int sizeOfB) {

		int i = sizeOfA - 1;
		int j = sizeOfB -1;
		int k = sizeOfA + sizeOfB-1;
		
		while(j >= 0)
		{
			if(i>=0 && a[i] > b[j])
			{
				a[k] = a[i];
				i--;
			}
			else
			{
				a[k] = b[j];
				j--;
			}
			k--;
		}
	}

}
