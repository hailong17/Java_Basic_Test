package Excercise1;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		try (Scanner myObj = new Scanner(System.in)) {
			System.out.println("Enter number one :");
			/* Get user input */
			int num1   = myObj.nextInt();
			System.out.println("Enter number two :");
			int num2   = myObj.nextInt();

			myObj.close();

			int result = num1 + num2;

			System.out.println("Output: " + result);
		}
	}
}
