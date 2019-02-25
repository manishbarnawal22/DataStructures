package com.sample.test2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Test3 {
	List list = new ArrayList();
	int test(int a, int b) {
		for (int i = a; i <= b; i++) {
			if (Math.sqrt(i) <= b && Math.sqrt(i)%1 == 0) {
				int recursiveCount = 0;
				list = countSquareRootRecursive(i, recursiveCount);
			}
		}
		 
		return (int) list.stream().sorted( Comparator.reverseOrder()).findFirst().get(); 
	}

	@SuppressWarnings("unchecked")
	List countSquareRootRecursive(int i, int recursiveCount) {
		if (Math.sqrt(i) > 0 &&  Math.sqrt(i)%1 == 0) {
			++recursiveCount;
			countSquareRootRecursive((int)Math.sqrt(i), recursiveCount);
			list.add(recursiveCount);
		}
		
		return list;
	}

	public static void main(String[] args) {
		int a = 600000;
		int b = 1000000;
		Test3 solutionObj = new Test3();
		System.out.print("Count is:" + (int) solutionObj.test(a, b));
	}
}
