package com.sample.string;

import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class FindFrequencyOfCharInString
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
            Map<Character, Integer> lMap1 = new TreeMap<>();
            Map<Character, Integer> lMap2 = new TreeMap<>();
            getFrequencyOfCharacters( lMap1, lStr1 );
            getFrequencyOfCharacters( lMap2, lStr2 );
            System.out.println( lMap1 );
            System.out.println( lMap2 );

            if( lMap1.equals( lMap2 ) )
            {
                System.out.println( "Anagrams" );
            }
            else
            {
                System.out.println( "Not Anagrams" );
            }
        }
    }

    private static Map<Character, Integer> getFrequencyOfCharacters( Map<Character, Integer> lMap,
                                                                     String lStr1 )
    {
        for( int i = 0; i < lStr1.length(); i++ )
        {
            Integer lCount = 0;
            for( int j = 0; j < lStr1.length(); j++ )
            {
                if( lStr1.charAt( i ) == lStr1.charAt( j ) )
                {
                    lMap.put( lStr1.charAt( i ), ++lCount );
                }
            }
        }
        return lMap;
    }

}
