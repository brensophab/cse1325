import java.util.Scanner;
import java.security.Key;
import java.security.MessageDigest;
import java.util.*;
import java.lang.String;

    interface cypher{
    public String encrypt(String unencrypted);
    public String decrypt(String encrypted);
    public void Substitution();
    String key = "qwertyuiopasdfghjklzxcvbnm";
}
public class Crypto implements cypher{
    private char[] c;
    void Rot13(char[] unencrypted){
        for(char c: unencrypted){
            if(c>= 'a' && c<='m'){
                c+=13;
            }
            else if(c <='a' && c>='m'){
                c -= 13;
            }
        }        
       System.out.println(unencrypted);
        
    }
        
        @Override
        public String encrypt(String unencrypted) {
            // 

            char[] u  = new char[unencrypted.length()];
            for(int i =0; i <unencrypted.length(); i++){
                u[i]=unencrypted.charAt(i);
               System.out.println(u[i]+=c[i]); //adding the value of the c[i] to u[i] to get the encrypted string
        

            }
            return unencrypted;
             
            
            
            
        }
        @Override
        public String decrypt(String encrypted) {
            
            char[] u  = new char[encrypted.length()];
            for(int i =0; i <encrypted.length(); i++){
                u[i]=encrypted.charAt(i);
               System.out.println(u[i]-=c[i]); //adding the value of the c[i] to u[i] to get the encrypted string
        

            }
            
            return encrypted;
        }





        @Override
        public void Substitution() {
            
            String key = "qwertyuiopasdfghjklzxcvbnm"; //Convert key to char array to iterate through
            char[] c = new char[key.length()];
            for(int i = 0; i <= key.length(); i++){
                c[i] = key.charAt(i);
            } // add entered string to ascii value of i
            
        }   
    public static void main(String[] args){
        // Method that prints out a key generated from key method
       System.out.println("Enter text to (E)ncrypt or (D)ecrypt. (Q) to quit \n");
        
           Scanner in = new Scanner(System.in);
           String response = in.nextLine().toLowerCase();
           if(response == "d"  ){
               System.out.println("Enter text to decrypt");
               Scanner textToDecrypt = new Scanner(System.in);
               String decryptText = in.nextLine();
               decryptText.decrypt();
           } // Print out the decrypted text in decrypt method.
           else if(response == "e"){
               System.out.println("Enter text to encrypt");
               Scanner textToEncrypt = new Scanner(System.in);
               String unencrypted = in.nextLine();
               unencrypted.encrypt();
           }
               //Print out the encrypted text in encrypt method
            else if(response == "q"){
            System.out.println("Exiting program...");
            break;
        }
    }
 

    



}
// Git didnt add every line?