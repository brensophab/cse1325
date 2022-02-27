import java.util.*;

 
abstract class Animal{
    enum Gender{
        Male, Female;
    }
    
    enum DogBreed{
        
        POODLE,SHIBA,HUSKY;   
    }
    
    enum CatBreed{
        BENGAL,SIAMESE,MUNCHKIN;
    }
    

    public Object animal(String name, Gender gender, int age){
        return null; 
    }

    public abstract String breed();
    private String name;
    private Gender gender;
    private int age;
    
}