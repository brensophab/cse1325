import java.util.Scanner;
import java.security.MessageDigest;

public class Crypto {
    public static void main(String[] args){
        // Method that prints out a key generated from key method
       System.out.println("Enter text to (E)ncrypt or (D)ecrypt. (Q) to quit \n");
    
           Scanner in = new Scanner(System.in);
           char response = in.nextLine().toLowerCase();
           if(response = 'D'  ){
               System.out.println("Enter text to decrypt");
               Scanner textToDecrypt = new Scanner(System.in);
               String decryptText = in.nextLine();
               decryptText.decrypt();
           } // Print out the decrypted text in decrypt method.
           else if(response = 'E'){
               System.out.println("Enter text to encrypt");
               Scanner textToEncrypt = new Scanner(System.in);
               String encryptText = in.nextline();
               encryptText.encrypt();
               //Print out the encrypted text in encrypt method
           }
    

    }
    public Rot13(){
        //3 lines rot13 encryption algo 
        return;
    }
    public interface cypher{
        public String encrypt(String unencrypted);
        public String decrypt(String encrypted);
        public Substitution();
    }
    
    

        public Substitution(String key){
            return;
        }

    }


// Git didnt add every line?