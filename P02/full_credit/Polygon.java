import java.util.*;
import java.util.Scanner;
public class Polygon(){
	private int side;
	private double perimeter;
	
	public double addSide(double length)//while getsides iterates, increment value(size) by one
	{
	double sum = 0;
	for(int i=0 i <side.length;i++)
	{
	sum +=getSides();
	}
	}
	public getSides()
	{
		 //iterates once and then passes value of length into getSides(i hope)
		
		Scanner in = new Scanner(System.in);
		length = in.nextInt();
		System.out.println("Side length(0 when done):");
		if(input==0)
		{
		break;
		}
		return length;	
		
		
	
	}
	public getPerimeter()
	{
	System.out.println("Perimeter of ""-sided polygon is " + addSide());
	}
	
	public static void main(String args[])
{
	 
		for(int i=0; i< side.length;i++)
		{
			getSides();
			
			i++;
		
		}
		getPerimeter();
		System.exit(0);
}
