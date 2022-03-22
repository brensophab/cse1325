package shelter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

public class Shelter {
    String name;
    ArrayList<Animal> animals;
    public Shelter(String newshelterName) {
        this.name = newshelterName;
        animals = new ArrayList<>();
    }
    public Shelter(BufferedReader in)throws IOException{
        this(in.readLine());
        int size = Integer.parseInt(in.readLine());
        for(int i =0; i <size; ++i){
            String animalBreed = in.readLine();
            switch(animalBreed){
                case Dog.dogID: animals.add(new Dog(in)); break;
                case Cat.catID: animals.add(new Cat(in)); break;
                default: throw new IOException("Invalid Animal" + animals);
            }
        }
    }

    public void save(BufferedWriter out)throws IOException{
        out.write(name + "\n");
        out.write(""+ animals.size() + "\n");
        for(Animal a  :animals){
            a.save(out);
        }
    }
    public String name() {
        return name;
    }
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
    public int numAnimals() {
        return animals.size();
    }
    public Animal getAnimal(int index) {
        return animals.get(index);
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for(Animal a : animals) {
            result.append((first ? "" : "\n") + a);
            first = false;
        }
        return result.toString();
    }
    
}