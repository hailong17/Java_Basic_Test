package Excercise1;

import java.util.Scanner;

public class readFloatingPoint {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter floating-point number :");
			/* Get user input */
			float number   = scanner.nextFloat();

			scanner.close();

			if (number == 0) {
				System.out.println("Zero");
			} else if (number > 0) {
				System.out.print("Positive ");
				if (Math.abs(number) < 1) {
					System.out.println("small");
				} else if (Math.abs(number) > 1_000_000) {
					System.out.println("large");
				}
			} else {
				System.out.print("Negative ");
				if (Math.abs(number) < 1) {
					System.out.println("small");
				} else if (Math.abs(number) > 1_000_000) {
					System.out.println("large");
		}
	}
	} catch (Exception ex) {
		System.out.println("Invalid value!");
	}
}
}


