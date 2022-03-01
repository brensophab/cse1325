import shelter.Cat;
import shelter.CatBreed;
import shelter.Dog;
import shelter.DogBreed;
import shelter.Gender;
import shelter.Shelter;


public class mass {
    public static void main(String[] args) {
      Shelter shelter = new Shelter("Mavericks Animal  Safety Shelter ");

      Dog dog1 = new Dog(DogBreed.HUSKY, "Beta", Gender.Male, 11);
      Cat cat1 = new Cat(CatBreed.BENGAL, "Foxtrot", Gender.Female, 9);

      shelter.addAnimal(dog1);
      shelter.addAnimal(cat1);

      for(int i = 0; i <shelter.numOfAnimals(); i++){
        System.out.println(shelter.toString(i));
      }
    }
}
