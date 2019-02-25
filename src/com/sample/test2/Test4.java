package com.sample.test2;

import java.util.TreeMap;
import java.util.TreeSet;

public class Test4 {

	public static void main(String[] args) {
		
		TreeSet<String> lTreeSet = new TreeSet<>();
		lTreeSet.add("Manish");
		lTreeSet.add("Barnawal");
		lTreeSet.add("Ranjeet");
		lTreeSet.add("Hegde");
		lTreeSet.add("Manish");
		lTreeSet.add("Arun");
		
		System.out.println("TreeSet:"+lTreeSet);
		
		TreeMap<Integer, String> lTreeMap = new TreeMap<>();
		lTreeMap.put(1,"Manish");
		lTreeMap.put(2,"Barnawal");
		lTreeMap.put(3,"Ranjeet");
		lTreeMap.put(4,"Hegde");
		lTreeMap.put(6,"Manish");
		lTreeMap.put(6,"Arun");
		
		System.out.println("TreeSet:"+lTreeMap);
	}

}
