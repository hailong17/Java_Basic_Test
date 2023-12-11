package Excercise4;



public class armstrongNumbers {
	public static void main(String[] args) {
		System.out.print("All Armstrong numbers between 1 and 500 is :");

		for (int number = 1; number < 500; number++){
			int originalNumber = number;
            int sum = 0;

            while (originalNumber != 0) {
                int digit = originalNumber % 10;
                sum += Math.pow(digit, 3);
                originalNumber /= 10;
            }

            if (sum == number) {
                System.out.println(number);
            }
		}
	}
}
