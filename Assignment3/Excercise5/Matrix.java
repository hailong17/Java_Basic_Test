package Excercise5;

import java.util.Random;
import java.util.Scanner;

public class Matrix {
	private int rows;
	private int columns;
	private int[][] array;

	public Matrix (int rows, int columns) {
		this.rows     = rows;
		this.columns  = columns;
		this.array    = new int[rows][columns];
	}

	public void createElement() {
		Random random = new Random();

		for (int i =  0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				array[i][j] = random.nextInt(100);
			}
		}
	}
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter number of rows: ");
			int rows  = scanner.nextInt();
			System.out.println("Enter number of columns: ");
			int columns = scanner.nextInt();
			scanner.close();

			Matrix matrix = new Matrix(rows, columns);
			matrix.createElement();

			System.out.println("Matrix is: ");
			for (int i = 0; i < matrix.rows; i++) {
            	for (int j = 0; j < matrix.columns; j++) {
                	System.out.print(matrix.array[i][j] + " ");
            	}
            	System.out.println();
			}
		} catch (Exception e) {
			System.out.println("Invalid value!");
		}

}
}
