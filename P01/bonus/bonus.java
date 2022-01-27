import java.util.Scanner;
class HelloWorld{
	public static void main(String []args){
	System.out.print("What is your name?");
	try (Scanner scan = new Scanner(System.in)) {
		String name = scan.next();
		System.out.println("Hello " + name);
	}
	}
}
