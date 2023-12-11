package Excercise5;

import java.util.Scanner;

public class naturalLogarithm {
	public static double computeNaturalLogarithm(int n) {
        double sum = 0.0;
        int sign = 1;

        for (int i = 1; i <= n; i++) {
            sum += sign * (1.0 / i);
            sign *= -1;
        }

        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter value of n: ");
        int n = scanner.nextInt();

        scanner.close();

        double result = computeNaturalLogarithm(n);

        System.out.println("Natural logarithm of 2 using " + n + " terms: " + result);
    }
}
