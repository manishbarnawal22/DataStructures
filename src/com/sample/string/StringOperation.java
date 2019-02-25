package com.sample.string;

import java.util.Scanner;

public class StringOperation {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        printTotalLength(A,B);
        isDigitLexicographicallyGreater(A,B);
        printStr(A,B);
        
    }
    
    private static void printTotalLength(String A, String B)
    {
        Integer strLength = A.length()+B.length();
        System.out.println(strLength); 
    }
    
    private static void isDigitLexicographicallyGreater(String A, String B)
    {
       if(compareTo( A,B )>0)
       {
           System.out.println("yes");    
       }
       else if(compareTo( A,B )<0)
       {
           System.out.println("No");    
       }
       else
       {
           System.out.println( "The both string "+A+" and "+B+" are equal" );
       }
       
    }
    
    private static void printStr(String A, String B)
    {
       System.out.println(Character.toUpperCase(A.charAt(0)) + A.substring(1) +" "+ Character.toUpperCase(B.charAt(0)) + B.substring(1));
    }
    
    private static int compareTo(String value,String anotherString) {
        int len1 = value.length();
        int len2 = anotherString.length();
        int lim = Math.min(len1, len2);
        char v1[] = value.toCharArray();
        char v2[] = anotherString.toCharArray();

        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;
    }
}