package com.sample.string;

import java.util.Scanner;

public class CheckAnagram
{

    public static void main( String[] args )
    {
        Scanner lScanner = new Scanner( System.in );
        String lStr1 = lScanner.next();
        String lStr2 = lScanner.next();
        
        int lengthStr1 = lStr1.length();
        int lengthStr2 = lStr2.length();
        
        if( lengthStr1 >= 1 && lengthStr1 <= 50 && lengthStr2 >= 1 && lengthStr2 <= 50 )
        {
            boolean lIsAnagram = isAnagram( lStr1, lStr2 );
            if( lIsAnagram == true )
            {
                System.out.println( "Anagrams" );
            }
            else
            {
                System.out.println( "Not Anagrams" );
            }
        }
    }

    private static boolean isAnagram( String str1,
                                      String str2 )
    {
        StringBuilder lStrBuilder = new StringBuilder(str2.toLowerCase());//abc
        char[]  lChar = str1.toLowerCase().toCharArray();//abcd
        for( char c : lChar )
        {
            int index = lStrBuilder.indexOf(""+ c );
            if(index != -1)
            {
                lStrBuilder.deleteCharAt( index );
            }
            else
            {
                return false;
            }
        }
        return lStrBuilder.length()==0? true: false;
    }
}
