package com.sample.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindAndRemoveDuplicateFromTwoArrays {

	public static void main(String[] args) {

		Integer[] arr1 = new Integer[] {2,4,6,8,6};
		Integer[] arr2 = new Integer[] {4, 4,9,10,2,9};
		
		Set<Integer> set1 = new HashSet<>();
		set1.addAll(Arrays.asList(arr1));
		Set<Integer> set2 = new HashSet<>();
		set2.addAll(Arrays.asList(arr2));
		System.out.println("Set1:"+set1);
		System.out.println("Set2:"+set2);
		
		for(Integer i: set2)
		{
			if(set1.contains(i))
			{
				set1.remove(i);
			}
		}
		
		System.out.println("After removal of duplicate elements:");
		System.out.println("Set1:"+set1);
		System.out.println("Set2:"+set2);
	}
}
