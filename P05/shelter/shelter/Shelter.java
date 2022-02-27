package shelter;
import java.util.ArrayList;
import java.util.List;

import shelter.Animal.DogBreed;



public class Shelter {
    
    private String name = "Grand Prairie Animal Shelter";
     ArrayList<Animal> animalList = new ArrayList<Animal>();
    
    

    public void addAnimal(Animal animal){
        animalList.add(DogBreed.SHIBA);
    }
    
    @Override
    public String toString(){
        return name;
    }
    
}
