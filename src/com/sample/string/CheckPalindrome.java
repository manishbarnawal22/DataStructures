package com.sample.string;

import java.util.Scanner;

public class CheckPalindrome
{
    public static void main( String[] args )
    {
        Scanner lScanner = new Scanner( System.in );
        String lInput = lScanner.next();
        Boolean lFlag = Boolean.FALSE;
        if( lInput.matches( ".*[a-z].*" ) && lInput.length() <= 50 )
        {
            for( int i = 0, j = lInput.length()-1; i < lInput.length() && j >= lInput.length()-1; i++, j-- )
            {
                if( lInput.charAt( i ) == lInput.charAt( j ) )
                {
                    lFlag = Boolean.TRUE;
                }
                else
                {
                    lFlag = Boolean.FALSE;
                    break;
                }
            }
        }
        if( lFlag == Boolean.TRUE )
        {
            System.out.println( "Yes" );
        }
        else
        {
            System.out.println( "No" );
        }
        
    }
}
