package Excercise2;
import java.util.Scanner;
public class Area {
	private float length;
	private float breadth;

	public Area(float length, float breadth) {
		this.length = length;
		this.breadth = breadth;
	}
	public float calculateArea() {
		return length * breadth;
	}

	public void displayArea(float area) {
		System.out.println("Area is: " + area);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter length: ");
		float length  = scanner.nextFloat();
		System.out.print("Enter breadth: ");
		float breadth = scanner.nextFloat();
		scanner.close();

		Area area = new Area(length, breadth);
		float areaCalculated = area.calculateArea();
		area.displayArea(areaCalculated);
	}
}
