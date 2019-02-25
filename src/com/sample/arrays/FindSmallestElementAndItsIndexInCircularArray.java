package com.sample.arrays;

public class FindSmallestElementAndItsIndexInCircularArray {

	Integer[] arr = new Integer[] { 4, 44, 2, 6, 3, 1 };

	void findSmallestElement() {
		int start = 1;
		int smallest = arr[2];
		int smallestElementIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			if(smallest > arr[(i + start) % arr.length])
			{
				smallest = arr[(i + start) % arr.length];
				smallestElementIndex = (i + start) % arr.length;
			}
		}
		System.out.println("The smallest element is :"+smallest+ " and the index is:"+ smallestElementIndex);
	}

	public static void main(String[] args) {

		FindSmallestElementAndItsIndexInCircularArray lObj = new FindSmallestElementAndItsIndexInCircularArray();
		lObj.findSmallestElement();
	}

}
