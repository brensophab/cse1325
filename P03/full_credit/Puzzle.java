import java.io.*;
import java.util.*;
import java.text.Normalizer;

public class Quint{
	public String compareGuess(String guess){
	//For actual and check, letters will be replaced with spaces when found
	Word actual = new Word(solution.toString());//puzzle solution
	Word check  =  new Word(guess); 				//Guess at solution
	Word result = new Word ("...."); 			//Result to be returned
	
	//Check for correct letter in correct position
	for(int i=0; i<5; ++i) {
		if(check.charAt(i)==actual.charAt(i)){
				result.setChartAt(Character.toUpperCase(solution.charAt(i)), i);
				check.setCharAt(' ', i);
				actual.setCharAt(' ', i);
				continue;
			}
		}
		
	}	
		
	
	public static void main(String[] args){
	System.out.println("Hello world!");
	}
	}
	
	
class Puzzle{
private Word solution;
private boolean solved;

}

class WordList{

}

class Word{

}
