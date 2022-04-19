package P05.shelter;

public class Cat extends Animal {
    
    


    public Cat(CatBreed breed, String name, Gender gender,int age){
        super(name, gender, age);
        this.breed = breed;
        if(age<0){
            throw new IllegalArgumentException("No negative age");
        }
    }
    

    @Override
    public String toString(){
        Cat cat = new Cat(CatBreed.BENGAL, "Delta", Gender.Male, 11);
        String Name = cat.getName();
        String Gender = cat.getGender();
        String Age = cat.getAge();

        return Name + " " + Age + " year old," + Gender + ", \n";
    }


    @Override
    public String breed() {
        String getBreed = breed.toString();
        return getBreed;
       
    }
    private CatBreed breed;
}

