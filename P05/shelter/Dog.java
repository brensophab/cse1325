package P05.shelter;

public class Dog extends Animal {
    
    


    public Dog(DogBreed breed, String name, Gender gender,int age){
        super(name, gender, age);
        this.breed = breed;
        if(age<0){
            throw new IllegalArgumentException("No negative age");
        }
    }
    

    @Override
    public String toString(){
        Dog dog = new Dog(DogBreed.HUSKY, "Alpha", Gender.Female, 4);
        String Name = dog.getName();
        String Gender = dog.getGender();
        String Age = dog.getAge();

        return Name + " " + Age + " year old," + Gender + ", \n";
    }


    @Override
    public String breed() {
        String getBreed = breed.toString();
        return getBreed;
       
    }
    private DogBreed breed;
}

