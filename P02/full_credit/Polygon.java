import java.util.*;
import java.util.Scanner;
public class Polygon{
	private int side;
	private double perimeter;
	
	public double addSide(double length)//while getsides iterates, increment value(size) by one
	{
	double sum = 0;
	while(getSide()!=0)// replace second arg
	{
	sum +=getSides();
	
	}
	return sum;
	}
	

	
	public int getSides()
	{
		 //iterates once and then passes value of length into getSides(i hope)
		
		Scanner in = new Scanner(System.in);
		int length = in.nextInt();
		System.out.println("Side length(0 when done):");
		if(input==0)
		{
		break;
		}
		return length;	
		
			
	}
	public int getPerimeter()
	{
	
	return addSide();
	}
	

	
	public static void main(String args[])
{
	 	int counter = 0;
		while(getSides()!=0) // add counter for sides here replace 2nd arg
		{
		
			getSides();
			
			
		if(getSides()>0)
		{
		 counter+=1;
		}
		}
		getPerimeter();
		System.out.println("Perimeter of "+counter+"-sided polygon is"+getPerimeter());
		System.exit(0);
}
}// i tried D:
