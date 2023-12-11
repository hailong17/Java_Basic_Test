package Excercise3;

import java.util.Scanner;

public class multiplyBinary {
	public static void main(String[] args) {
		try (Scanner myObj = new Scanner(System.in)) {
			System.out.println("Enter binary number one :");
			/* Get user input */
			String num1   = myObj.next();
			System.out.println("Enter binary number two :");
			/* Get user input */
			String num2   = myObj.next();

			myObj.close();

			int decimal1 = Integer.parseInt(num1, 2);
			int decimal2 = Integer.parseInt(num2, 2);
			int multiply = decimal1 * decimal2;

			String result = Integer.toBinaryString(multiply);

			System.out.println("Output: " + result);
		} catch (Exception ex) {
			System.out.println("Invalid value! It does not binary number!");
		}
	}
}
