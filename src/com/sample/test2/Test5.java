package com.sample.test2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Test5 {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(2,3,4,5,6,7,8,9);
		Integer totalSum = list.stream().filter(x->x%2==0).mapToInt(x->x).sum();
		
		System.out.println("Sum of even number is:"+totalSum);
		
		Integer totalSum1 = list.stream().filter(x->x%2==0).mapToInt(x->x).sum();
		System.out.println("Sum of even number is:"+totalSum1);
		
		Integer sumUsingReducer = list.stream().filter(x->x%2==0).reduce((sum,x)->x+sum).get();
		System.out.println("Sum of even number using reduce is:"+sumUsingReducer);
		
		//First non repeating in a String
		/*String str = "geekforgeek";
		char[] lCharArray = str.toCharArray();
		Integer count = 0;
		
		Map<Character, Integer> lMap = new LinkedHashMap<>();
		for (char c : lCharArray) {
			if(lMap.containsKey(c))
			{
				lMap.put(c, ++count);
			}
			else
			{
				lMap.put(c, count);
			}
		}
		
		for(int i=0; i< lMap.size(); i++)
		{
			if(lMap.get(lCharArray[i]) == 1)
			{
				System.out.println("First non repeating:"+lCharArray[i]);
				break;
			}
		}*/
		
		
		if(Math.sqrt(10)%1 == 0)
		{
			System.out.println("Is an integer");
		}
	}

}
