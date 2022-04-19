package P05.shelter;

public abstract class Animal{
     
    public String getName() {
        return this.name;        
        
      }
    public String getGender() {
        String getGender = this.gender.toString();
        return getGender;
      }
      public String getAge() {
        String buffer = " " + this.age;
        return buffer;
      }
    
    

    public Animal(String name, Gender gender, int age){
    this.name = name;
    this.gender = gender;
    this.age = age;
    
    }

    @Override
    public String toString(){
        return name + " " + age + " " + gender + "\n";
    }

    public abstract String breed();
    protected String name;
    protected Gender gender;
    protected int age;
    

    
}