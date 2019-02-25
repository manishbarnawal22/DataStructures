package com.sample.test2;

import java.util.ArrayList;
import java.util.List;

public class Test6 {

	public static void main(String[] args) {
		
		System.out.println(new Calculator().number(8).sub().number(6).output());
	} 
}

class Calculator
{
	int x ;
	String op;
	List<Integer> list = new ArrayList<>();
	Calculator number(int x)
	{
		list.add(x);
		return this;
	}
	
	Calculator add()
	{
		this.op = "+";
		return this;
	}
	
	Calculator sub()
	{
		this.op = "-";
		return this;
	}
	
	int output()
	{
		switch(op)
		{
		case "+": 
			
			return list.stream().mapToInt(i->i).sum();
		
		case "-":
			return list.get(0)-list.get(1);
		
		}
		return this.x;
	}
}