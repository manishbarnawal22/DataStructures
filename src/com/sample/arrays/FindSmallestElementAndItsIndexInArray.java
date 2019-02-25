package com.sample.arrays;

public class FindSmallestElementAndItsIndexInArray {

	Integer[] arr = new Integer[] {4,44,2,6,3,1};
	
	void findSmallestElement()
	{
		int index = 0;
		int minimum = arr[0];
		for(int i=0; i< arr.length; i++)
		{
			if(minimum < arr[i])
			{
				continue;
			}
			else
			{
				minimum = arr[i];
				index = i;
			}
		}
		System.out.println("The minimum element is:"+minimum+" and the index is:"+index);
	}
	
	public static void main(String[] args) {

		FindSmallestElementAndItsIndexInArray lObj = new FindSmallestElementAndItsIndexInArray();
		lObj.findSmallestElement();
	}

}
