package shelter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public abstract class Animal{
  public Animal(String name, Gender gender, int age){
    if(age<0) throw new IllegalArgumentException(name + ": Age must be positive");
    this.name = name;
    this.gender = gender;
    this.age = age;
  }
  public Animal(BufferedReader in) throws IOException{
    this.name = in.readLine();
    this.gender = Gender.valueOf(in.readLine());
    this.age = Integer.parseInt(in.readLine());
  }
  public void save(BufferedWriter out) throws IOException{
    out.write("" + name + "\n");
    out.write("" + gender + '\n');
    out.write("" + age + "\n");
  }
  public abstract String family();
  public abstract String breed();
  public String name(){return name;}
  public int age(){return age;}
  public String toString(){
    return name + " (" + age + " year old" + gender;}
  
  private String name;
  private Gender gender;
  private int age;
  }