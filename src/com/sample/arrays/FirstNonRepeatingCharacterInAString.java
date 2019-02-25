package com.sample.arrays;

import java.util.LinkedHashMap;
import java.util.Map;

//Java program to find first non-repeating character

class FirstNonRepeatingCharacterInAString
{
    static final int NO_OF_CHARS = 256;
    static char count[] = new char[NO_OF_CHARS];

    // Driver method
    public static void main( String[] args )
    {
        String str = "geeksforgeeks";
        int index = firstNonRepeating( str );

        System.out.println( index == -1 ? "Either all characters are repeating or string " + "is empty"
            : "First non-repeating character is " + str.charAt( index ) );
        
        firstNonRepeatingUsingMap( str );
    }
    
    /* calculate count of characters 
    in the passed string */
    static void getCharCountArray( String str )
    {
        for( int i = 0; i < str.length(); i++ )
            count[str.charAt( i )]++;
    }

    /* The method returns index of first non-repeating
    character in a string. If all characters are repeating 
    then returns -1 */
    static int firstNonRepeating( String str )
    {
        getCharCountArray( str );
        int index = -1, i;

        for( i = 0; i < str.length(); i++ )
        {
            if( count[str.charAt( i )] == 1 )
            {
                index = i;
                break;
            }
        }

        return index;
    }
    
    static void firstNonRepeatingUsingMap(String str)
    {
		char[] lCharArray = str.toCharArray();
		Integer count = 0;
		
		Map<Character, Integer> lMap = new LinkedHashMap<>();
		for (char c : lCharArray) {
			if(lMap.containsKey(c))
			{
				lMap.put(c, ++count);
			}
			else
			{
				lMap.put(c, count);
			}
		}
		
		for(int i=0; i< lMap.size(); i++)
		{
			if(lMap.get(lCharArray[i]) == 1)
			{
				System.out.println("First non repeating:"+lCharArray[i]);
				break;
			}
		}
	
    }
}