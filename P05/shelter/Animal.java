package shelter;

import java.util.*;

 
public abstract class Animal{
    enum Gender{
        Male, Female;
    }
    
    
    
    
    

    public String animal(String name, String gender, int age){
    this.name = name;
    this.gender = gender;
    this.age = age;
    return name + ", "+ gender + ", " + age + "years old";
    }

    public abstract String breed();
    protected String name;
    protected String gender;
    protected int age;
    
}