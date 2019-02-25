package com.sample.string;

import java.util.Scanner;

public class CheckPalindromeSolution2
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String revA = new StringBuilder(A).reverse().toString();
        System.out.println(((A.compareTo(revA) == 0)) ? "Yes" : "No");
    }
}
