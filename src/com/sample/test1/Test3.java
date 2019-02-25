package com.sample.test1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer l = 123;
		Integer i1 = 12;
        Integer i2 = 12;
        i1.equals( i2 );
		
		StringBuilder lstrblr = new StringBuilder(l+"");
		System.out.println(lstrblr);
		
		Map map = new HashMap();
		map.put("message", "hello");
		
		System.out.println(map.get("message"));
		
		List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

		System.out.println("Filtered List: " + filtered);
		String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("Merged String: " + mergedString);
		
		System.out.println("Stream without terminal operation");
	     
	    Arrays.stream(new int[] { 1, 2, 3 }).map(i -> {
	        System.out.println("doubling " + i);
	        return i * 2;
	    });
	  
	    System.out.println("Stream with terminal operation");
	        System.out.println(Arrays.stream(new int[] { 1, 2, 3 }).map(i -> {
	            System.out.println("doubling " + i);
	            return i * 2;
	    }).sum());
	}

}
