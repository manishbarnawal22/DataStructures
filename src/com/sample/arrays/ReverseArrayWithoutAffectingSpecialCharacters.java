package com.sample.arrays;

//input "Ab,c,de!$";
//output "ed,c,bA!$"

//input "abc$de!$"
//output "edc$ba!$"

public class ReverseArrayWithoutAffectingSpecialCharacters {

	public static void main(String[] args) throws Exception {
		String str="abc$de!$";
		//String str="Ab,c,de!$";
		char[] strArray = str.toCharArray();
		
		//solutionUsingNtimeComplexityAndMoreSpaceComplexity(strArray, temp);
		
		efficientSolution(strArray);
		
		printArray(strArray);
	}

	private static void efficientSolution(char[] str) {

		// Initialize left and right pointers
        int r = str.length - 1, l = 0;
 
        // Traverse string from both ends until
        // 'l' and 'r'
        while (l < r)
        {
            // Ignore special characters
            if (!Character.isAlphabetic(str[l]))
                l++;
            else if(!Character.isAlphabetic(str[r]))
                r--;
 
            // Both str[l] and str[r] are not spacial
            else
            {
                char tmp = str[l];
                str[l] = str[r];
                str[r] = tmp;
                l++;
                r--;
            }
        }
	}

	//this has O(n) time complexity but space complexity is more. 
	private static void solutionUsingNtimeComplexityAndMoreSpaceComplexity(char[] strArray) {
		
		char[] temp = new char[strArray.length];
		
		int j=0, i=0;
		while(i<strArray.length)
		{
			if(Character.isAlphabetic(strArray[i]))
			{
				temp[j] = strArray[i];
				i++;
				j++;
			}
			else
			{
				i++;
			}
		}

		char[] lCharArr = reverseTempArray(temp, j);
		//replace input string character with the reversed array characters
		int k=0; int m=0;
		while( k<strArray.length)
		{
			if(Character.isAlphabetic(strArray[k]))
			{
				strArray[k]=lCharArr[m];
				m++;
				k++;
			}
			else
			{
				k++;
			}
			
		}
	}

	private static void printArray(char[] strArray) {

		for(int i=0;i<strArray.length; i++)
		{
			System.out.print(strArray[i]);
		}
	}

	private static char[] reverseTempArray(char[] charArr, int j) {
		int start = 0;
		int end = j-1;
		
		while(start < end)
		{
				char temp = charArr[start];
				charArr[start] = charArr[end];
				charArr[end] = temp;
				start++;
				end--;
		}
		return charArr;
	}
	
	
}
