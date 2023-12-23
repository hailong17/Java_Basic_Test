import java.util.Scanner;

class Area {
    private double length;
    private double breadth;

    public Area(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public double returnArea() {
        return length * breadth;
    }
}

public class Main {
    public static void main(String[] args) {
        double length = 0;
        double breadth = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter length: ");
            length = scanner.nextDouble();

            System.out.print("Enter breadth: ");
            breadth = scanner.nextDouble();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /* Increase value of length and breadth */ 
        for (int i = 0; i < 30; i++) {
            length++;
            breadth++;
            Area area = new Area(length, breadth);
            double result = area.returnArea();
            System.out.println("Area " + i + " time is: " + result);
        }
    }
}