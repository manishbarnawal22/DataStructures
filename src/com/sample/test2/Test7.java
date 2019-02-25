package com.sample.test2;


class Abc
{
	final int x =20;
	void method1(int x)
	{
		System.out.println("In method1 of Abc");
	}
}

public class Test7 extends Abc{
	
	int x=10;
	@Override
	public void method1(int x)
	{
		System.out.println("In method1 of Test7");
	}
	
	public static void main(String[] args) {
		Abc test = new Test7();
		System.out.println(test.x);
	}
}
