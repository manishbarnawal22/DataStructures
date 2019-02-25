package com.sample.string;

public class CheckAnagrmUsingMatcher {

	public static void main(String[] args) {

		String str1 = "creative";
		String str2 ="reactive";
		
		if(str1.length() != str2.length())
		{
			System.out.println("Not Anagram");
		}
		
		Boolean flag = false;
		for(char lChar : str1.toCharArray())
		{
			int lCount1 = str1.length() - str1.replaceAll(lChar+"", "").length();
			int lCount2 = str2.length() - str2.replaceAll(lChar+"", "").length();
			if(lCount1 == lCount2)
			{
				flag=true;
				continue;
			}
			else
			{
				flag=false;
				break;
			}
		}
		
		if(flag==false)
		{
			System.out.println("Not Anagram");
		}
		else
		{
			System.out.println("Anagram");
		}
	}

}
