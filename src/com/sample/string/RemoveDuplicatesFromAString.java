package com.sample.string;

import java.util.Arrays;

public abstract class RemoveDuplicatesFromAString {

	public static void main(String[] args) {

		String str = "aaaamanissha";

		iterativeWayOfRemovingDuplicate(str);
		//System.out.println(clean(str));
	}
	
	private static void iterativeWayOfRemovingDuplicate(String str) {
		char[] lCharArr = str.toCharArray();
		Arrays.sort(lCharArr);
		
		int j=1;
		int i=1;
		while(i<lCharArr.length)
		{
			if(lCharArr[i] != lCharArr[i-1])
			{
				lCharArr[j] = lCharArr[i];
				j++;
			}
			i++;
		}
		
		String str1 = new String(lCharArr);
		System.out.println(str1.substring(0, j));
	}

	static String clean(String str){
        String old = "", nev = "";
        for (int i=0; i<str.length()-1; i++){
            if (str.charAt(i) == str.charAt(i+1)){
                old = str.substring(i, i+2);
                nev = str.substring(i, i+1);
                str = clean(str.replace(old, nev));
            }
        }
        return str;
    }
}
