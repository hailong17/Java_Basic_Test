package Excercise3;

import java.util.Scanner;

public class angleTriangle {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter number of row of pattern :");
			/* Get user input */
			int rows   = scanner.nextInt();

			scanner.close();

			for (int i = 1; i <= rows; i++) {
				for ( int j = 1; j <= i; j++) {
					System.out.print(i);
				}
				System.out.println();
			}
		} catch (Exception ex) {
			System.out.println("Invalid value!");
		}
	}
}
