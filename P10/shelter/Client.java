package P10.shelter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Client {
    public Client(String name, String phone){
        super();
        this.name = name;
        this.phone = phone;
    }
    public Client(BufferedReader in)throws IOException{
        this.name = in.readLine();
        this.phone = in.readLine();
    }
    public void save(BufferedWriter out)throws IOException{
        out.write(""+ name + "\n");
        out.write(""+ phone + "\n");
    }
    
    @Override
    public String toString(){
        return name +", " + " (" + phone + ")";
    }
    
    private String name;
    private String phone;
}
