import java.util.Scanner;

class Area {
	private double length;
	private double breadth;
	
	public Area(double length, double breadth) {
		this.length  = length;
		this.breadth = breadth;
	}
	
	public double returnArea() {
		return length*breadth;
	}
}

public class Main {

	public static void main(String[] args) {
		double length  = 0;
		double breadth = 0;
		
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter length :");
			/* Get user input */
			length    = scanner.nextDouble();
			
			System.out.print("Enter breadth :");
			/* Get user input */
			breadth   = scanner.nextDouble();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Area area = new Area(length,breadth);
		System.out.println(area.returnArea());
	}

}
