package P10.shelter;

import java.io.BufferedReader;
import java.io.IOException;

public class Turtle extends Animal {
    public Turtle(TurtleBreed breed, String name, Gender gender, int age){
        super(name, gender, age);
        this.breed = breed;

    }
    public Turtle(){
        this(TurtleBreed.AFRICAN, "Default", Gender.FEMALE, 0);
    }
    public Turtle(BufferedReader br)throws IOException{
        super(br);
        breed = TurtleBreed.valueOf(br.readLine());

    }
    


@Override
public String family() {
    return "Turtle";
}
@Override
public String breed() {
    return breed.name();
    }
    @Override
    public String toString(){
        return super.toString() + " " + breed.name() + "Turtle";
    }

    private TurtleBreed breed;
}