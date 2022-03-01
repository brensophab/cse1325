package shelter;
import java.util.ArrayList;




public class Shelter {
    
    public Shelter(String shelterName){
        this.shelterName = shelterName;
        this.animals = new ArrayList<>();
    }
    String name(){return shelterName;}
    
    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    public int numOfAnimals(){
        return animals.size();
    }
    public String toString(int index){
        return animals.get(index).toString();
    }
    @Override
    public String toString(){
        String result =  shelterName + "\n" ;
        for(int i = 0; i<animals.size(); i++){
            result +=i + " " + animals.get(i) + "\n";
        }
        return result;
    }
    
    private String shelterName;
    private ArrayList<Animal> animals;
}
