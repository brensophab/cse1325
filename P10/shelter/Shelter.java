package P10.shelter;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Shelter {
private static final String cat = (new Cat()).family();
private static final String dog = (new Dog()).family();

public Shelter(String name){
    this.name = name;
    this.filename = "Untitled.mass";
    animals = new ArrayList<>();
    clients = new ArrayList<>();    
}

public Shelter(BufferedReader br)throws IOException{
    this.name = br.readLine();
    this.filename = "Untitled.mass";
    int numAnimals = Integer.parseInt(br.readLine());
    while(numAnimals-->0){
        String f =br.readLine();
        if(f.equals(cat)){
            animals.add(new Cat(br));
    }
        else if(f.equals(dog)){
            animals.add(new Dog(br));
        }
        else throw new IOException("Unknown animal family: " + f);
    }
  }

public void save(BufferedWriter bw)throws IOException{
    bw.write(name + "\n");
    bw.write(filename + "\n");
    for(Animal a: animals){
        bw.write(a.family() + "\n");
        a.save(bw);
    }
}

public String getName(){
    return name;
}

public String getFilename(){
    return filename;
}

public void setFilename(String filename){
    this.filename = filename;
}
public void addAnimal(Animal animal){
    animals.add(animal);
}
public void addClient(Client client){
    clients.add(client);
}
public int numAnimals(){
    return animals.size();
}
public Animal getAnimal(int index){
    return animals.get(index);
}
public String clientToString(){
    StringBuilder sb = new StringBuilder();
    boolean first = true;
    for(Client c: clients){
        sb.append((first ? "":"\n") + c);
    }
    return sb.toString();
}
@Override
public String toString(){
    StringBuilder result = new StringBuilder();
    boolean first = true;
    for(Animal a: animals){
        result.append((first ? "": "\n") + a);
        first = false;
    }
    return result.toString();
}


private String filename;
private String name;
private ArrayList<Animal> animals;
private ArrayList<Client> clients;
}
