package shelter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Dog extends Animal {
    public static final String dogID = "Dog";
    public Dog(DogBreed breed, String name, Gender gender, int age) {
        super(name, gender, age);
        this.breed = breed;
    }
    public Dog(BufferedReader in) throws IOException {
        super(in);
        this.breed = DogBreed.valueOf(in.readLine());

    }
    public void save(BufferedWriter out) throws IOException{
        out.write(dogID + "\n");
        super.save(out);
        out.write("" + breed + "\n");
    }
    @Override
    public String family() {
        return "dog";
    }
    @Override
    public String breed() {
        return breed.name();
    }
    @Override
    public String toString() {
        return super.toString() + " " + breed.name() + " dog)";
    }
    private DogBreed breed;
}
