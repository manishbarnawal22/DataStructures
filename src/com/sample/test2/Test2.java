package com.sample.test2;

import java.util.ArrayList;
import java.util.TreeMap;

//No Nullpointer
public class Test2
{

    public static void main( String args[] )
    {
    	/*TreeSet<String> ts = new TreeSet<>();
    	ts.add("Manish");
    	ts.add("Sreedhar");
    	ts.add("Mayur");
    	
    	System.out.println(ts);
    	ts.tailSet("Manish");
    	
    	HashSet<String> hs = new HashSet<>();
    	hs.add("Manish");
    	hs.add("Sreedhar");
    	hs.add("Mayur");
    	
    	System.out.println(hs);*/
    	ArrayList list = new ArrayList<>();
    	Employee e1 = Employee.INSTANCE123;
    	Employee e2 = Employee.INSTANCE123;
    	e1.setId(11);
    	e2.setId(22);
    	System.out.println(e1.hashCode()== e2.hashCode());
    	
    	
    	
    	System.out.println(e1.equals(e2));
    	
    	/*String str = "Manish";
    	String str1 = new String("Manish");
    	System.out.println(str.equals(str1));
    	System.out.println(str==str1);
    	
    	Balloon lRed = new Balloon("Red", "RedRound");
    	Balloon lBlue = new Balloon("Blue","BlueOval");
    	
    	swap(lRed, lBlue);
    	
    	System.out.println("lRed:"+lRed);
    	System.out.println("lBlue:"+lBlue);
    	
    	int i = 1;
    	while(i>0)
    	{
    		Balloon b = new Balloon("sder","jkjkkj");
    		System.out.println(b.toString());
    		i++;
    	}*/
    	
    	
    	/*Employee emp1 = new Employee("Manish", 30);
    	Employee emp2 = new Employee("Manish", 30);
    	
    	System.out.println(emp1.equals(emp2));*/
    	
    	
    }

	private static void swap(Balloon lRed, Balloon lBlue) {
		Balloon temp = lRed;
		lRed = lBlue;
		lBlue = temp;
		TreeMap lMap = new TreeMap<>();
		lBlue.shape="yellow";
		
		
	}
}

class Balloon
{
	String shape;
	String str;
	Balloon(String color, String shape)
	{
		this.str=color;
		this.shape= shape;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "color:"+str+",shape:"+shape;
	}
}


class Employee1
{
	private String name;
	private Integer age;
	
	Employee1(String name, Integer age)
	{
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int hashCode() {

		System.out.println(this.hashCode());
		return this.hashCode();
	}
	
	@Override
	public boolean equals(Object obj)
	{
		return this.name==((Employee1)obj).name;
	}
}
