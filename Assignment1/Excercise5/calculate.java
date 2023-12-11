package Excercise5;

import java.util.Scanner;

public class calculate {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter distance in meters:");
			/* Get user input */
			double distance   = scanner.nextDouble();

			System.out.println("Enter hours:");
			/* Get user input */
			int hours   = scanner.nextInt();

			System.out.println("Enter minutes:");
			/* Get user input */
			int minutes   = scanner.nextInt();

			System.out.println("Enter seconds:");
			/* Get user input */
			int seconds   = scanner.nextInt();

			scanner.close();
			int totalTimeSecond             = hours*60*60 + minutes*60 + seconds;
			double speedMetersPerSecond     = distance/totalTimeSecond;
			double speedKiloMetersPerHours  = (distance/1000.0)/(totalTimeSecond/3600.0);
			double speedMilesPerHours       = (distance/1609.0)/(totalTimeSecond/3600.0);

			System.out.println("Your speed in meters/second is: " + speedMetersPerSecond);
			System.out.println("Your speed in kilometers/hour is: " + speedKiloMetersPerHours);
			System.out.println("Your speed in miles/hour is: " + speedMilesPerHours);
		} catch (Exception e) {
			System.out.println("Invalid value!");
		}
}
}
