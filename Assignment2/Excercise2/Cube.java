package Excercise2;
import java.util.Scanner;

public class Cube {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)){
			System.out.print("Enter number :");
			/* Get user input */
			int number   = scanner.nextInt();

			scanner.close();

			for (int i = 1; i <= number; i++) {
				System.out.println("Number is : " + i + " and cube of " + i + " is :" + i*i*i);
			}

		} catch (Exception ex) {
			System.out.println("Invalid value!");
		}

	}
}
