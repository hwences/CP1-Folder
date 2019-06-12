
import java.util.Scanner;

public class UserInputScanner{
	public static void main(String[] args){
		Scanner kin = new Scanner(System.in);

		System.out.print("What is your first name? ");
		String first = kin.nextLine();
		
		System.out.print("What is your last name? ");
		String last = kin.nextLine();

		System.out.println("Hello "+ first + " " + last + ", it's nice to meet you!");
		
		System.out.print("What is your address? ");
		String address = kin.nextLine();

		System.out.print("What is the city that you live in? ");
		String city = kin.nextLine();
		
		System.out.print("What state do you live in? ");
		String state = kin.nextLine();
		
		System.out.print("What is your zip code? ");
		String zip = kin.nextLine();

		System.out.println(first + " " + last);
		System.out.println(address);
		System.out.println(city + " " + state + " " + zip);
				
	}
}
