package com.sample.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Inheritance {

	public static void main(String[] args) {
		
		/*Animal cat = new Cat();
		cat.makeSound();*/
		
		Cat cat1 = new Cat();
		cat1.makeSound("I am cat I sound meow meow");
		
		/*Animal animal = new Animal();
		animal.makeSound();
		
		AutoBoxing autoBoxing = new AutoBoxing();
		long sumIs = autoBoxing.addNumber(5, 10);
		System.out.println("The sumIs:"+sumIs);
		
		float sumIs1 = sumIs;
		System.out.println("After unboxing:"+sumIs1);*/
		
	}

}

class Animal
{
	void makeSound()
	{
		System.out.println("Make sound");
	}
	
	void makeSound(String str)
	{
		System.out.println("Compile time");
	}
}

interface Mammal
{
	int getEyesCharacterstics();
	
	default void hasHairs()
	{
		System.out.println("Mammal Has Hairs");
	}
}

class Cat extends Animal implements Mammal 
{
	private static final int LEGS = 4;
	
	public int getLegs(int legs)
	{
		return LEGS;
	}
	
	@Override
	void makeSound()
	{
		System.out.println("Inside cat.");
	}
	
	void makeSound(String sound)
	{
		System.out.println("Inside Cat:"+sound);
	}

	@Override
	public int getEyesCharacterstics() {
		// TODO Auto-generated method stub
		return 2;
	}
}


class AutoBoxing
{
	long addNumber(long x, long y)
	{
		return x+y;
	}
}


