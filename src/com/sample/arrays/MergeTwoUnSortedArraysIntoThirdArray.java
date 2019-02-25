package com.sample.arrays;

import java.util.Arrays;

public class MergeTwoUnSortedArraysIntoThirdArray {

	public static void main(String[] args) {

		int a[] = { 10, 5, 15 };
		int b[] = { 20, 3, 2, 12 };
		int n = a.length;
		int m = b.length;

		// Final merge list
		int res[] = new int[n + m];
		//sortedMerge(a, b, res, n, m);
		sortedMergeLessTime(a, b, res, n, m);
		
		System.out.print("Sorted merged list :");
		for (int i = 0; i < n + m; i++)
			System.out.print(" " + res[i]);
	}

	// First merge the two arrays and then sort the final array using
	// Arrays.sort
	// this gives time complexity of O((n+m)log(n+m))
	// Auxiliary Space O(n+m)
	// For getting the Time complexity of O(nlogn+mlogm+(n+m)) we first sort the
	// two arrays and then merge into third array.
	// Solution is into another method sortedMergeLessTime() below
	private static void sortedMerge(int[] a, int[] b, int[] res, int n, int m) {
		{
			// Concatenate two arrays
			int i = 0, j = 0, k = 0;
			while (i < n) {
				res[k] = a[i];
				i++;
				k++;
			}

			while (j < m) {
				res[k] = b[j];
				j++;
				k++;
			}

			// sorting the res array
			Arrays.sort(res);
		}
	}

	private static void sortedMergeLessTime(int a[], int b[], int res[], int n, int m) {
		// Sorting a[] and b[]
		Arrays.sort(a);
		Arrays.sort(b);

		// Merge two sorted arrays into res[]
		int i = 0, j = 0, k = 0;

		while (i < n && j < m) 
		{
			if (a[i] <= b[j]) 
			{
				res[k] = a[i];
				i += 1;
				k += 1;
			} 
			else 
			{
				res[k] = b[j];
				j += 1;
				k += 1;
			}
		}

		while (i < n) { // Merging remaining
						// elements of a[] (if any)
			res[k] = a[i];
			i += 1;
			k += 1;
		}
		while (j < m) { // Merging remaining
						// elements of b[] (if any)
			res[k] = b[j];
			j += 1;
			k += 1;
		}
	}
}
