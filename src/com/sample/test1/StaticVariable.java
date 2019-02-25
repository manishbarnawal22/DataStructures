package com.sample.test1;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class StaticVariable
{

    public static void main( String[] args ) throws InterruptedException
    {
        A.c1 = 8;
        A.c2 = 9;
        
        System.out.println( "c1:"+A.c1+" c2:"+A.c2 );
        
        B b = new B();
        b.method1();
    }
}

class A
{
    static Integer c1=3;
    static Integer c2=4;
}

class B
{
    void method1()
    {
        System.out.println( "In class B >>>>>>c1:"+A.c1+" c2:"+A.c2 );
    }
}