package P05.mass;

import P05.shelter.Cat;
import P05.shelter.CatBreed;
import P05.shelter.Dog;
import P05.shelter.DogBreed;
import P05.shelter.Gender;
import P05.shelter.Shelter;


public class mass {
    public static void main(String[] args) {
      Shelter shelter = new Shelter("Mavericks Animal  Safety Shelter ");
        System.out.println(shelter + "\n");
      Dog dog1 = new Dog(DogBreed.HUSKY, "Beta", Gender.Male, 11);
      Cat cat1 = new Cat(CatBreed.BENGAL, "Foxtrot", Gender.Female, 9);
    
      shelter.addAnimal(dog1);
      shelter.addAnimal(cat1);

      for(int i = 0; i <shelter.numOfAnimals(); i++){
        System.out.println(shelter.toString(i));
      }
    }
}
