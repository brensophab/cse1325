package shelter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
public class Cat extends Animal {
    public static final String catID = "Cat";
    public Cat(CatBreed breed, String name, Gender gender, int age){
        super(name, gender, age);
        this.breed = breed;

    }
    public Cat(BufferedReader in) throws IOException {
        super(in);
        this.breed = CatBreed.valueOf(in.readLine());

    }
    public void save(BufferedWriter out) throws IOException{
        out.write(catID + "\n");
        super.save(out);
        out.write("" + breed + "\n");
    }
    @Override
    public String family(){
        return "cat";
    }
    @Override
    public String breed(){
        return breed.name();
    }
    @Override
    public String toString(){
        return super.toString() + " " + breed.name() + " cat)";
    }
    private CatBreed breed;
}

