package com.sample.string;

public class ReverseStringOfSentence
{

    public static void main( String[] args )
    {
        String str = "Atlas is a success";
        System.out.println( str );
        char[] lCharArray = str.toCharArray();
        
        String[] lArrayWords = new String[6];
        StringBuilder lSb = new StringBuilder();
        Integer lCountWord = 0;
        for( int i=0; i <= lCharArray.length-1; i++ )
        {
            lSb = lSb.append( lCharArray[i] );
            if(lCharArray[i] != ' ' && i != lCharArray.length-1)
            {
                continue;
            }
            else
            {
                lArrayWords[lCountWord++] = lSb.toString();
                lSb.setLength( 0 );
            }
        }
        
        for( int j=lArrayWords.length-1; j>=0; j-- )
        {
            System.out.print(" " +lArrayWords[j] );
        }
       
    }

}
