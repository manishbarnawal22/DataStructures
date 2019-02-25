package com.sample.string;

import java.util.Scanner;

public class StringOperation2
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int start = in.nextInt();
        int end = in.nextInt();
        
        if(S.length()>=1 && S.length() <=100 && start>=0 && start<end )
        {
            System.out.println(S.substring(start,end));    
        }  
    }
}
