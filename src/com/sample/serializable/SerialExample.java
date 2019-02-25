package com.sample.serializable;

//Java code for serialization and deserialization  
// of a Java object 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//If we run this program once by enabling both serialize and deserialize method, it prints the updated static value of b.
//But if we run the same in two JVM, means in first time only do serialize and the comment serialize and do only deserialize
//this should print the static b value as 0.

class Emp implements Serializable {
	private static final long serialVersionUID = 13654790L;
	transient int a;
	static int b;
	String name;
	int age;
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public static int getB() {
		return b;
	}

	public static void setB(int b) {
		Emp.b = b;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

public class SerialExample {
	public static void printdata(Emp object1) {

		System.out.println("name = " + object1.name);
		System.out.println("age = " + object1.age);
		System.out.println("a = " + object1.a);
		System.out.println("b = " + object1.b);
	}

	public static void main(String[] args) {

		String fileName = "abc.txt";
		//serialize(fileName);
		deserialize(fileName);
	}

	private static void deserialize(String fileName) {

		// Deserialization
		try {

			// Reading the object from a file
			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object
			Emp tes = (Emp) in.readObject();

			in.close();
			file.close();
			System.out.println("Object has been deserialized\n" + "Data after Deserialization.");
			printdata(tes);

		}

		catch (IOException ex) {
			ex.printStackTrace();
			System.out.println();
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException" + " is caught");
		}
	}

	private static void serialize(String fileName) {

		//Emp object = new Emp("ab", 20, 2);

		Emp object = new Emp();
		object.setAge(20);
		object.setName("ab");
		object.setB(25);
		object.setA(2);
		
		// Serialization
		try {

			// Saving of object in a file
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);

			// Method for serialization of object
			out.writeObject(object);

			out.close();
			file.close();

			System.out.println("Object has been serialized\n" + "Data before Deserialization.");
			printdata(object);

			// value of static variable changed
			 object.b = 2000;
		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}

	}
}