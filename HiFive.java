
import java.util.Scanner;

public class HiFive{
	public static void main(String[] args){
		Scanner kin = new Scanner(System.in);

		System.out.print("Enter a value: ");
		int value = kin.nextInt();

		System.out.println();

		if(value % 5 == 0){
			System.out.println("Hi Five");
		}

		if(value % 2 == 0){
			System.out.println("Hi Even");
		}
	}
}
