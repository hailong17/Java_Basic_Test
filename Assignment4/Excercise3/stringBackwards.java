package Excercise3;

import java.util.Random;
import java.util.Scanner;

public class stringBackwards implements CharSequence {
    private String data;

    public stringBackwards(String data) {
        this.data = data;
    }

    public int length() {
        return data.length();
    }

    public char charAt(int index) {
        return data.charAt(data.length() - 1 - index);
    }

    public CharSequence subSequence(int start, int end) {
        StringBuilder builder = new StringBuilder(end - start);
        for (int i = end - 1; i >= start; i--) {
            builder.append(data.charAt(i));
        }
        return builder.toString();
    }

    public String toString() {
        return data;
    }

    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter sentence: ");
        String sentence = scanner.nextLine();
		scanner.close();

		Random random            = new Random();
		int index                = random.nextInt(sentence.length());
		int index_start          = random.nextInt(sentence.length());
		int index_end            = random.nextInt(sentence.length());
        stringBackwards sequence = new stringBackwards(sentence);

        System.out.println("Original Sentence: " + sequence.toString());
        System.out.println("Length: " + sequence.length());
        System.out.println("Character at index " + index + " is :"+ sequence.charAt(index));
        System.out.println("Subsequence from index " + index_start + " to " + index_end + " is: " + sequence.subSequence(index_start, index_end));
    }
}
