package com.sample.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Manish implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 132112L;

    private String name;
    private String test;
    private String gender;

    public Manish( String name,
        String gender,
        String test )
    {
        super();
        this.name = name;
        this.gender = gender;
        this.test = test;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Vinod [name=" + name + ", gender=" + gender + "]";
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender( String gender )
    {
        this.gender = gender;
    }
}

public class TestSerialUUID
{

    public static void main( String[] args ) throws IOException, ClassNotFoundException
    {

        //serialize();
        deSerialize();
    }

    private static void deSerialize() throws IOException, ClassNotFoundException
    {

        FileInputStream lFileInputStream = new FileInputStream( "Test1.obj" );
        ObjectInputStream lObjectInputStream = new ObjectInputStream( lFileInputStream );
        Object readObject = lObjectInputStream.readObject();

        System.out.println( readObject );
    }

    private static void serialize() throws FileNotFoundException, IOException
    {
        Manish lManish = new Manish( "Vinod", "Male", "Test" );
        FileOutputStream lFileOutputStream = new FileOutputStream( "Test1.obj" );
        ObjectOutputStream lObjectOutputStream = new ObjectOutputStream( lFileOutputStream );
        lObjectOutputStream.writeObject( lManish );
        lObjectOutputStream.close();
        System.out.println( "Serialization Done" );
    }

}
