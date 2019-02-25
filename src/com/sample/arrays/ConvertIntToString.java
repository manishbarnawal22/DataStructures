package com.sample.arrays;

public class ConvertIntToString
{

    public static void main( String[] args )
    {
        int var = 143289;
        String str = convert( var );
        System.out.println( str );
    }
    
    static int getlength(int x){
        int length = 0;
        while(x/10 != 0) {
            x=x/10;
            length++;
        }
        return length;
    }
    
    static String convert(int x){
        char[] x_char = new char[getlength(x)+1];
        for(int i = x_char.length-1; i>=0; i--){
        	//ASCII VALUE 48 has character value as '0' and on first iteration
            //143289 % 10 + 48= 9+48 = 9+0 = 9 type casted to char becomes '9'
            x_char[i] = (char)(x % 10 + 48);
            x = x / 10;
        }
        return new String(x_char);
    }
}
