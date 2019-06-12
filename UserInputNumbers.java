
import java.util.Scanner;

public class UserInputNumbers{
	public static void main(String[] args){
		Scanner kin = new Scanner(System.in);

		System.out.print("Enter a radius(as an integer): ");
		int radius = kin.nextInt();
		
		System.out.println();
		System.out.println("The area of the circle is: " + (3.14*radius*radius));
		
		
	}
}
