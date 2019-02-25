package com.sample.java8.feature;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;

public class Student  implements Comparable<Student> 
{
    Student(Integer id, Integer age, String name)
    {
        this.id=id;
        this.age=age;
        this.name=name;
    }
    
    private Integer  id;
    private Integer age;
    private String name;
    public Integer getId()
    {
        return id;
    }
    public void setId( Integer id )
    {
        this.id = id;
    }
    public Integer getAge()
    {
        return age;
    }
    public void setAge( Integer age )
    {
        this.age = age;
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
    public int compareTo( Student o )
    {
        return name.compareTo( o.getName() );
    }
    
    private static void changeData(File targetFile, Map<String,String> substitutionData) throws IOException{

        BufferedReader br = null;
        String docxTemplate = "";
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(targetFile), "UTF-8"));
            String temp;
            while( (temp = br.readLine()) != null)
                docxTemplate = docxTemplate + temp; 
            br.close();
            targetFile.delete();
        } 
        catch (IOException e) {
            br.close();
            throw e;
        }

        Iterator substitutionDataIterator = substitutionData.entrySet().iterator();
        while(substitutionDataIterator.hasNext()){
            Map.Entry<String,String> pair = (Map.Entry<String,String>)substitutionDataIterator.next();
            if(docxTemplate.contains(pair.getKey())){
                if(pair.getValue() != null)
                    docxTemplate = docxTemplate.replace(pair.getKey(), pair.getValue());
                else
                    docxTemplate = docxTemplate.replace(pair.getKey(), "NEDOSTAJE");
            }
        }

        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(targetFile);
            fos.write(docxTemplate.getBytes("UTF-8"));
            fos.close();
        }
        catch (IOException e) {
            fos.close();
            throw e;
        }
    }

}
