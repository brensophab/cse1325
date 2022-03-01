package shelter;

enum CatBreed{
    BENGAL,SIAMESE,MUNCHKIN;
}
public class Cat extends Animal {

     

    

    Cat(String name, String gender, int age, String breed){
        super();
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    
    public String breed() {
        CatBreed cat;
        cat = CatBreed.SIAMESE;
        switch (cat){
            case BENGAL: return "Bengal";
            case SIAMESE: return "Siamese";
            case MUNCHKIN: return "Munchkin";
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
