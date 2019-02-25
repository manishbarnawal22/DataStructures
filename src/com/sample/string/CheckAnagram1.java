package com.sample.string;

public class CheckAnagram1 {

	public static void main(String[] args) {
		
		String str1 = "creative";
		String str2 = "reactiveq";
		
		Boolean lFlag = false;
		StringBuilder lStrBuilder2 = new StringBuilder(str2.toLowerCase());
		char[] str1Arr = str1.toLowerCase().toCharArray();
		for (char c : str1Arr) {
			
			int index = lStrBuilder2.indexOf(c+"");
			if(index!=-1)
			{
				lStrBuilder2.deleteCharAt(index);
			}
		}
		String lAnagram = lStrBuilder2.length()==0?"String is Anagram":"Not Anagram";
		System.out.println(lAnagram);
		
		
	}
	
}
