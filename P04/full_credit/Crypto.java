import java.util.Scanner;
import java.security.MessageDigest;

public class Crypto {
    public static void main(String[] args){
       // main code goes here System.out.println("Hello world!");

    }
    public Rot13(){
        //3 lines rot13 encryption algo
    }
    
    class Substitution (){ //extend the Cypher interface here i think
        char encryptKey = new char[26];
        char decryptKey = new char[26];

        public Substitution(String key){

        }

        public encrypt Cypher(String unencrypted){

        }
        
        public decrypt Cypher(String encrypted){

        }

    }


    interface Cypher{
        public String encrypt(String unencrypted);
        public String decrypt(String encrypted);
    }  
}
// Git didnt add every line?