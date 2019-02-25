package com.sample.file;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortAFileByLineOnWordCountOfEachLine {

	public static void main(String[] args) throws IOException {

		String lPath = "E:\\projects\\SampleProject\\src\\input";
		FileInputStream fis = new FileInputStream(new File(lPath));
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		
		List<String> myList = new ArrayList<String>();
		String line;
		while((line = br.readLine()) != null)
		{
			myList.add(line);
		}
		
		System.out.println("Sort using WordCountComparator:");
		
		Collections.sort(myList, new WordCountComparator().wordCountComparator);
		printList(myList);
		
		System.out.println("--------------------------");
		
		//*****************************************************
		//The below two works the same way
		System.out.println("Sort using Alphabetical Order Comparator 1:");
		Collections.sort(myList, new WordCountComparator().alphabeticalOrder);
		printList(myList);
		
		System.out.println("--------------------------");
		
		System.out.println("Sort using Alphabetical Order Comparator:");
		Collections.sort(myList, new WordCountComparator().alphabeticalOrderComparator);
		printList(myList);
		//*******************************************************
	}
	
	static void printList(List<String> list)
	{
		for(String str: list)
		{
			System.out.println(str);
		}
	}
}

class WordCountComparator
{
	//The below commented code is as same as the java 8 implementation mentioned down
	/*@Override
	public int compare(String str1, String str2) {
		
		String[] wordsArr1 = str1.split(" ");
		String[] wordsArr2 = str2.split(" ");
		if(wordsArr2.length < wordsArr1.length)
		{
			return -1;
		}
		else if(wordsArr2.length > wordsArr1.length)
		{
			return +1;
		}
		else
		{
			return 0;
		}
	}*/
	
	Comparator<String> wordCountComparator = ((str1, str2) -> {
		return -(str1.split(" ").length - str2.split(" ").length);
	}
	);
	
	Comparator<String> alphabeticalOrderComparator = ((str1, str2)->{
		int strLen1 = str1.length();
		int strLen2 = str2.length();
		
		for(int i=0; i< strLen1 && i< strLen2; i++)
		{
			int str1_ch = (int)str1.charAt(i);
			int str2_ch = (int)str2.charAt(i);
			
			if(str1_ch == str2_ch)
			{
				continue;
			}
			else
			{
				return str1_ch-str2_ch;
			}
		}
		return 0;
	});
	
	Comparator<String> alphabeticalOrder = ((str1, str2)->{
		return str1.compareTo(str2);
	});
	
}

