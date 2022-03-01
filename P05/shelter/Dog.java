package shelter;
enum DogBreed{
        
    POODLE,SHIBA,HUSKY;   
}
public class Dog extends Animal {
    
    Dog(String name, String gender, int age, String breed){
        super();
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    
    public String breed() {
        DogBreed dog = DogBreed.HUSKY;
        switch (dog){
            case POODLE: return "Poodle";
            case SHIBA: return "Shiba";
            case HUSKY: return "Husky";
            default:
            System.out.println("not in our shelter");
            break;
        }
        return "debug";
    }

    @Override
    public String toString(){
        return animal(name, gender, age);
    }
    
}

